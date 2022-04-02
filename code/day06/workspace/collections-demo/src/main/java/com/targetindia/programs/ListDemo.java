package com.targetindia.programs;

import java.util.List;
import java.util.Vector;

public class ListDemo {

    public static void main(String[] args) {

        List<String> names = new Vector<>();
        names.add("Vinod");
        names.add("Kushal");
        names.add("Naveen");
        names.add("Vinod");
        names.add("Vishal");
        names.add("Ramesh");

        System.out.println(names);
        System.out.println("size of names is " + names.size());
        names.add(0, "Shyam");
        System.out.println(names);
        names.add(7, "Kishore");
        System.out.println(names);
        names.add(2, "Kiran");
        System.out.println(names);

    }
}
