package CoreJava.String;

 class A{
    int a = 1;


}
class B extends A{
    public void add()
    {
        System.out.println(a);
    }
}

public class StringVsStringBuffer {

    public static void main(String[] args) {

//        String string = new String("Deven");
//
//        string.concat(" Jain");
//
//        System.out.println("Concated String : " + string);
//
//        StringBuilder stringBuilder = new StringBuilder("Deven");
//
//        stringBuilder.append(" Jain");
//
//        System.out.println("Appended String : " + stringBuilder);
//
//        String s = new String();
//
//        s = "deven";
//
//        System.out.println(string.concat("ABC"));

        new B().add();

        int[] n1 = new int[0];
        boolean[] n2 = new boolean[200];
        System.out.println(n2);
    }
}
