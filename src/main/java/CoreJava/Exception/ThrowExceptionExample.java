package CoreJava.Exception;

import java.io.IOException;

class ThrowExceptionClass{

    public static void validateAge(int age)  {

        if(age < 18){

            throw new ArithmeticException("Invalidte age");

        }
        else{

            System.out.println("Valid age");

        }

    }

}

public class ThrowExceptionExample {

    public static void main(String[] args){

        ThrowExceptionClass object = new ThrowExceptionClass();

        try {
            ThrowExceptionClass.validateAge(13);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        System.out.println("Other code");

    }

}
