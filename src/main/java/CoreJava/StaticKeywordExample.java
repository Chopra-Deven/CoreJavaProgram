package CoreJava;

public class StaticKeywordExample {

    static int number;
    int id;
    {
        System.out.println("inside non-static");
        id = 10;
//        number = 10;
    }

    static{
        System.out.println("inside static");
        number = 1;
    }

    public static void main(String[] args) {

//        byte byteNumber = 1288;

        System.out.println("Main Method called");
        System.out.println("Number : " + StaticKeywordExample.number);
        System.out.println("ID : " + new StaticKeywordExample().id);
    }
}
