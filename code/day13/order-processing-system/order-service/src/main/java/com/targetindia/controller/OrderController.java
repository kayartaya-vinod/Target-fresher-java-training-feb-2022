package com.targetindia.controller;

import com.targetindia.dao.OrderDao;
import com.targetindia.entity.Order;
import com.targetindia.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Value("${service.url.shipper}")
    private String shipperServiceUrl;

    @Value("${service.url.customer}")
    private String customerServiceUrl;

    @Value("${service.url.employee}")
    private String employeeServiceUrl;

    @Value("${service.url.product}")
    private String productServiceUrl;

    @Autowired
    private OrderDao dao;

    @Autowired
    private RestTemplate template;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        Optional<Order> result = dao.findById(id);
        if (result.isEmpty()) {
            Map<String, Object> err = new HashMap<>();
            err.put("status", 404);
            err.put("message", "No order data found for id: " + id);
            err.put("timestamp", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }

        Order order = result.get();
        log.debug("There are {} line items for this order {}", order.getLineItems().size(), order.getId());

        // add data in "order" to an OrderDto object
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setRequiredDate(order.getRequiredDate());
        dto.setShippedDate(order.getShippedDate());
        dto.setFreight(order.getFreight());
        dto.setShippingName(order.getShippingName());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setShippingCity(order.getShippingCity());
        dto.setShippingRegion(order.getShippingRegion());
        dto.setShippingPostalCode(order.getShippingPostalCode());
        dto.setShippingCountry(order.getShippingCountry());

        order.getLineItems().stream()
                .forEach(li -> {
                    LineItemDto liDto = new LineItemDto();

                    // go and get product for this productId and add this to the lineItemDto
                    try {
                        WebClient client = WebClient.create(productServiceUrl + li.getProductId());
                        ProductDto product = client
                                .get()
                                .retrieve()
                                .bodyToMono(ProductDto.class)
                                .block();
                        liDto.setProduct(product);
                    } catch (Exception e) {
                        log.warn("Exception while getting data from customer service", e);
                    }

                    liDto.setUnitPrice(li.getUnitPrice());
                    liDto.setQuantity(li.getQuantity());
                    liDto.setDiscount(li.getDiscount());
                    dto.getLineItems().add(liDto);
                });

        try {
            // go and get the shipper data for the shipper id: order.getShippedBy()
            ShipperDto shippedBy = template.getForObject(shipperServiceUrl + order.getShippedBy(), ShipperDto.class);
            dto.setShippedBy(shippedBy);
        } catch (RestClientException e) {
            log.warn("Exception while getting data from shipper service", e);
        }

        try {
            // go and get the customer data for the customer id: order.getCustomerId()
            WebClient client = WebClient.create(customerServiceUrl + order.getCustomerId());
            CustomerDto customer = client
                    .get()
                    .retrieve()
                    .bodyToMono(CustomerDto.class)
                    .block();
            dto.setCustomer(customer);
        } catch (Exception e) {
            log.warn("Exception while getting data from customer service", e);
        }

        try {
            // go and get the employee data for the employee id: order.getEmployeeId()
            WebClient client = WebClient.create(employeeServiceUrl + order.getEmployeeId());
            EmployeeDto employee = client
                    .get()
                    .retrieve()
                    .bodyToMono(EmployeeDto.class)
                    .block();
            dto.setEmployee(employee);
        } catch (Exception e) {
            log.warn("Exception while getting data from employee service", e);
        }

        return ResponseEntity.ok(dto);
    }

}
