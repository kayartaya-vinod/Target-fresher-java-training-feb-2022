package com.targetindia.programs;

public class FinalVariablesDemo {

    static class Test {
        final int num;
        final static int anotherNum;

        static {
            anotherNum = 100;
        }

        Test(int num){
            this.num = num;
        }


    }

    public static void main(String[] args) {
        Test t1 = new Test(100);


    }
}
