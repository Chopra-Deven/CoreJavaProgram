package CoreJava;

class Five{
    public void method(){

    }
}
public class TestExample2 {



    public static void main(String[] args) {

        TestExample2 o = new TestExample2();
//        o.add(10,10);

        StringBuilder sb1 = new StringBuilder("Nile");
        StringBuilder sb2 = new StringBuilder("Nile");

        System.out.println(sb1==sb2);

    }

    public void display(int x, String... s){
        System.out.println(s[s.length-x]);
    }
}
