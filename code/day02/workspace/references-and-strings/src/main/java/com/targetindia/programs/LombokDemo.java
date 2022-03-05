package com.targetindia.programs;

import com.targetindia.model.Book;
import com.targetindia.model.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokDemo {

    public static void main(String[] args) {

        Product p = new Product();
        p.setId(123);
        p.setName("Logitech Mouse");
        p.setDescription("Sleek optic mouse from Logitech");
        p.setUnitPrice(4500);
        p.setUnitPrice(12);

        log.debug("Product p = {}", p); // p.toString() is called to represent p as a string

        Book b1 = new Book();
        b1.setId(123);
        b1.setTitle("Java Unleashed");
        b1.setAuthor("Unknown");

        log.debug("Book b1 = {}", b1); // b1.toString() is called to represent b1 as a string
    }
}
