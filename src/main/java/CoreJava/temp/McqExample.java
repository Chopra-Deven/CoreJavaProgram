package CoreJava.temp;

class A {
    public static void printName(){

        System.out.println("Value-A");
    }
}

class B extends A{

    public static void printName(){
        System.out.println("Value-B");
    }
}
public class McqExample {

    public static void main(String[] args) {

        A a = new B();
        a.printName();

    }
}
