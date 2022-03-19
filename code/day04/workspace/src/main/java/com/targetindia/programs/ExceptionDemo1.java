package com.targetindia.programs;

public class ExceptionDemo1 {

    public static void main(String[] args) {
        try {
            String input1 = args[0];
            String input2 = args[1];
            int num = Integer.parseInt(input1);
            int den = Integer.valueOf(input2);
            int quo = num / den;
            int rem = num % den;

            System.out.println(num + " divided by " + den +
                    " results into quotient of " + quo +
                    ", and a remainder of " + rem);
        }
        catch(ArithmeticException ex){
            System.out.println("Cannot divide by zero");
            System.exit(1);
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException ex){
            System.out.println("Please input 2 integers");
        }
        catch (Exception ex){
            System.out.println("OOPS! Something went wrong.");
        }
        finally {
            System.out.println("From inside of finally block");
        }

        System.out.println("End of main");
    }
}
