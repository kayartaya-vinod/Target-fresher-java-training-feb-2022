package com.targetindia.programs;

import com.targetindia.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccessModifierDemo {

    static Logger log = LoggerFactory.getLogger("com.targetindia.programs");

    public static void main(String[] args) {

        Book b1; // reference variable in stack; must refer to an object in the heap

        b1 = new Book();

//        b1.id = -202;
//        b1.title = "Let us C";
//        b1.author = "Yashwant Kanitkar";

        b1.setId(9876);
        b1.setTitle("Let us C");
        b1.setAuthor("Yashwant Kanitkar");

        log.debug("b1.id is {}", b1.getId());
        log.debug("b1.title is {}", b1.getTitle());
        log.debug("b1.author is {}", b1.getAuthor());

    }
}
