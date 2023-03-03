package CoreJava.Exception;

class CloeClass{

    int i = 10;

    public void display(){

        System.out.println("Number : " + i);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ClonableObject {

    public static void main(String[] args) {


    }
}
