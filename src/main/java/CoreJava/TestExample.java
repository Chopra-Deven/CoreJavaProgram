package CoreJava;

class BaseClass{

    int number1;

    BaseClass(){

        System.out.println("Base Constructor");

        number1 = 10;

        display();
    }

    public void display(){

        System.out.println("Base Number : " + number1);
    }
}

class ChildClass extends BaseClass{

    int number2;

    ChildClass(){

        System.out.println("Child Constructor");

        number2 = 20;

        display();
    }

    @Override
    public void display(){
        System.out.println("Child Number : " + 20);
    }
}

public class TestExample extends BaseClass{

    public static void main(String[] args) {

        BaseClass object = new ChildClass();
//        object.display();
    }

}
