package CoreJava.Generics;

import java.util.ArrayList;

public class GenericsExample {

    public static void main(String[] args) {

        CustomGen<String> generic1 = new CustomGen<String>("Deven");
        generic1.show();
        System.out.println(generic1.getObj());

        CustomGen<Integer> generic2 = new CustomGen<Integer>(10);
        generic2.show();
        System.out.println(generic2.getObj());

      /*  ArrayList<String> list  = new ArrayList<>();
        list.add("Deven");*/


        CustomGenNumeric<Integer> numGeneric = new CustomGenNumeric<Integer>(100);
        numGeneric.show();
        System.out.println(numGeneric.getObj());



    }
}
