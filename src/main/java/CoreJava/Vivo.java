package CoreJava;

public class Vivo extends AndroidOS {


    public static void main(String[] args) {

        AndroidOS object = new Vivo();

        Requirements interfaceObject = new Vivo();

        System.out.print("Abstract : " );

        System.out.println(object instanceof Vivo);

        interfaceObject.calling();

        object.message();

        object.notificationService();
    }

    @Override
    public void charging() {

        System.out.println("Charging Animation");
    }

    @Override
    public void message() {

        System.out.println("Message : Good Morning");
    }
}
