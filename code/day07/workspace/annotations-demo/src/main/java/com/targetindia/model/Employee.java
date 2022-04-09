package com.targetindia.model;

import com.targetindia.annotations.MyAnnotation;

//@MyAnnotation(value = 123)
//@MyAnnotation(123)
@MyAnnotation(title = "This is a new title", value=123)
public class Employee {

    // @MyAnnotation // error; target is set as "Type"
    private int id;
    private String name;
}
