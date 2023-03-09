package CoreJava.Generics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenericMethodClass{

    public static void getList(List<?> list){

        System.out.println(list);
    }

    public static double getSum(List<? extends Number> numbers){

        double sum = 0;

        for (Number number : numbers){

            System.out.println(number.doubleValue());

            sum += number.doubleValue();
        }

       for (int i=0 ; i<numbers.size() ; i++){
            sum += numbers.get(i).doubleValue();
        }

        return sum;
    }

}

public class WildCardExample {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

        list.add("Deven");
        list.add("Chopra");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);

        GenericMethodClass.getList(list);

        GenericMethodClass.getList(list2);

        System.out.println("Result : " + GenericMethodClass.getSum(list2));

        List<Double> list3 = Arrays.asList(10.1,10.2,10.3,10.4,10.5);

        System.out.println("Double Sum : " + GenericMethodClass.getSum(list3));

    }

}
