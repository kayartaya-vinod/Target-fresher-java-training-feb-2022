package com.targetindia.programs;


import com.targetindia.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReferencesDemo {

    static Logger log = LoggerFactory.getLogger(ReferencesDemo.class);

    public static void main(String[] args) {
        int num = 100; // memory for local primitive variables are allocated in the stack itself
        log.trace("Testing references...");
        Employee emp; // references are created in the stack (8 bytes)

        emp = new Employee(); // now memory is allocated in the heap
        log.debug("value im nums is {} and emp is {}", num, emp);

        emp.id = 1122;
        emp.name = "Shyam Sundar KC"; // 15 chars --> 30 bytes
        emp.salary = 78000.0;

        log.info("id = {}", emp.id);
        log.info("name = {}", emp.name);
        log.info("salary = {}", emp.salary);

        log.warn("this is a warning");
        log.error("this is an error");

        emp.printInfo();
    }
}
