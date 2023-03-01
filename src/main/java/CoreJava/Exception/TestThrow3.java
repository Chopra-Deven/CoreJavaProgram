package CoreJava.Exception;
import java.io.*;

class M{
    void method() throws IOException{
        throw new IOException("device error");
    }

    void msg() throws ArithmeticException{

        System.out.println("Message");

    }

    void throwError(){

        throw new Error();

    }
}


class TestThrow extends M{

    void msg() {

    }
    public static void main(String args[]) {//declare exception

        M m = new M();

        try {

            m.method();

        } catch (IOException e) {

            System.out.println("Catched");

        }

        try{

            m.throwError();
        }

        catch (Exception e) {

            System.out.println("Catched Error");

        }

        System.out.println("normal flow...");
    }
}

