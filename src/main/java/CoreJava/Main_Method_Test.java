package CoreJava;

class VariableClass{

    private final int i;

    VariableClass(int i){

        this.i = i;
    }


    public int getI() {
        return i;
    }



}

public class Main_Method_Test {
    final public static void main(String[] args) {



        for (String s : args) {
            System.out.println(s);
        }

        System.out.println("Hello hiii");

        String s = "Deven";

        System.out.println(s.intern());

        System.out.println(new VariableClass(10).getI());

        /*final int i = 10;

        while(i>20)
            System.out.println("Hello");*/

        if(false)
            System.out.println("Cahnduuuuuuuuuuuoooooooooooooooo");

        char String = 'I';

        short y = 10;
        y = (short) (y * 5);

        byte x = 127;
        x++;
        x++;
        System.out.println(x);

        int number = 016;
        System.out.println(number);


    }
}
