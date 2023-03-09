package CoreJava;

class A{

    final int number;

    A(){
        number=100;
    }

}
class B{
    VariableExample ve = new VariableExample();
}
public class VariableExample extends A{

    int number = 10;

    VariableExample obj = new VariableExample();

    public static void main(String[] args) {

        A a = new A();

        System.out.println(a.number);

        System.out.println("Hii");

    }
}
