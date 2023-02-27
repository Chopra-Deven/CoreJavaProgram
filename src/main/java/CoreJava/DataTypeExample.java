package CoreJava;

import java.util.Scanner;

public class DataTypeExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total Number : ");
        int choices = scanner.nextInt();

        for (int i=1 ; i<=choices ; i++){

            System.out.println("Enter Number : ");
            long number = scanner.nextLong();

            System.out.println(number+" can be fitted in: ");

            if (number>=-127 && number<=128){
                System.out.println("* in byte");
            }

            if (number>=Short.MIN_VALUE && number<=Short.MAX_VALUE){
                System.out.println("* in Short");
            }

            if (number>=-Integer.MIN_VALUE && number<=Integer.MAX_VALUE){
                System.out.println("* in int");
            }

            if (number>=-Long.MIN_VALUE && number<=Integer.MAX_VALUE){
                System.out.println("* in long");
            }


        }

    }

}
