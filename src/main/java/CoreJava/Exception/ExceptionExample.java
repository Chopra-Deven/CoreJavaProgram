package CoreJava.Exception;

import javax.sound.midi.Soundbank;

public class ExceptionExample {

    public static void main(String[] args) {

        try {

            int result = 100 / 0;

            System.out.println("result : " + result);

        } catch (ArithmeticException e) {

            System.out.println(e);

        } finally {
            System.out.println("arithmetic");
        }


        System.out.println("Outside");


    }

}
