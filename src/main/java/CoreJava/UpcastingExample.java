package CoreJava;

public class UpcastingExample {

}

class Bike {

//    int speed = 100;

    void run() {
        System.out.println("running");
    }
}

class Splendor extends Bike {

    int speed = 60;
    void run() {
        System.out.println("running safely with 60km");
    }

    public static void main(String args[]) {

        Bike b = new Splendor();//upcasting
        b.run();
        System.out.println("speed of bike : " + ((Splendor) b).speed);
        System.out.println(b instanceof Splendor);
    }
}
