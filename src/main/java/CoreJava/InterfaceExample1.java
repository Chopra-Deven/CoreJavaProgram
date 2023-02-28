package CoreJava;

interface MyInterface {
    int MY_CONSTANT = 100;

    void abstractMethod();

    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
}


interface Animal{

    void speak();

}
class dog implements Animal{


    @Override
    public void speak() {
        System.out.println("bhow bhow");
    }
}
class cat implements Animal{
    @Override
    public void speak() {
        System.out.println("meow");
    }
}
class mouse implements Animal{
    @Override
    public void speak() {
        System.out.println("choo choo");
    }
}

public class InterfaceExample1 {

   static void speak(Animal a){

        a.speak();
    }

    public static void main(String[] args) {

        dog d = new dog();
        cat c = new cat();
        mouse m = new mouse();

        speak(d);
        speak(c);
        speak(m);

        System.out.println(MyInterface.MY_CONSTANT);
//        MyInterface.MY_CONSTANT = 10;
    }
}
