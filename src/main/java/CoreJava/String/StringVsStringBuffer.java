package CoreJava.String;

public class StringVsStringBuffer {

    public static void main(String[] args) {

        String string = new String("Deven");

        string.concat(" Jain");

        System.out.println("Concated String : " + string);

        StringBuilder stringBuilder = new StringBuilder("Deven");

        stringBuilder.append(" Jain");

        System.out.println("Appended String : " + stringBuilder);

        String s = new String();

        s = "deven";

        System.out.println(string.concat("ABC"));
    }
}
