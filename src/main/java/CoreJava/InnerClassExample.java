package CoreJava;

class OuterClass{

    class Inner{

        public void show(){
            System.out.println("Show called");
        }

    }

    Inner inner = new Inner();

}

public class InnerClassExample {

    public static void main(String[] args) {

        OuterClass outer = new OuterClass();

        outer.inner.show();

        OuterClass.Inner inner = new OuterClass().new Inner();

        inner.show();

    }
}
