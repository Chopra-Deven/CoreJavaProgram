package CoreJava.temp;

class A {
    public static void printName() {

        System.out.println("Value-A");
    }
}

class B extends A {

    public static void printName() {
        System.out.println("Value-B");
    }
}

public class McqExample {

    public static void main(String[] args) {

        A a = new B();

        for (int i = 0; i < 1000; i++) {
            McqExample obj = new McqExample();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        a.printName();

    }
}
