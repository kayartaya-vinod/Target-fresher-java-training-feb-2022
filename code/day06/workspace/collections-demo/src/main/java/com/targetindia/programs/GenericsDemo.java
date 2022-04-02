package com.targetindia.programs;


class Test<T> {

    private T member;

    public Test(){
    }

    public Test(T member){
        this.member = member;
    }

    public T get(){
        return member;
    }

}

public class GenericsDemo {

    public static void main(String[] args) {
        Test<String> t1;
        Test<Integer> t2;


        t1 = new Test<>("Vinod");
        t2 = new Test<>(123);

        String x = t1.get();
        Integer y = t2.get();

        System.out.printf("x = %s, y = %s%n", x, y);
    }
}
