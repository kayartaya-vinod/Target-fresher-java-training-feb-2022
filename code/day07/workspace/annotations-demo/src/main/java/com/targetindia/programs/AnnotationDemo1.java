package com.targetindia.programs;

import com.targetindia.model.Employee;

import java.lang.annotation.Annotation;

public class AnnotationDemo1 {

    public static void main(String[] args) throws Exception{

        Employee emp = new Employee();
        System.out.println(emp);

        Annotation[] annotations = emp.getClass().getAnnotations();
        System.out.println("Following annotations are found for the class " + emp.getClass().getName());
        for(Annotation a: annotations){
            System.out.println(a);
        }
    }
}
