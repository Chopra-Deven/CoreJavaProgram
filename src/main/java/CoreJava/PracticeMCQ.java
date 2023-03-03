package CoreJava;

class Grandparent {
    public void print() {
        System.out.println("Grandparent's Print()");
    }
}

class Parent2 extends Grandparent {
    public void print() {
        super.print();
        System.out.println("Parent's Print()");
    }
}

class Child2 extends Parent2 {
    public void print() {
        super.print();
        System.out.println("Child's Print()");
    }
}

public class PracticeMCQ {

    public static void main(String[] args) {

        Integer i = 10;

        System.out.println(i);

        Child2 child = new Child2();

        child.print();

        String s = "yash";
        int a=10;
        int b=20;
        String s1 = s + 10 + 20;
        String s2 = "yash1020";



    }


}
