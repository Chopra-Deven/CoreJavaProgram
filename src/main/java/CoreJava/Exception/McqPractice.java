package CoreJava.Exception;

import java.sql.SQLOutput;

class Rect
{
    public Rect area(int length, int width){
        return new Rect();
    }
}

class Squre extends Rect{
    public Squre area(int length, int width){
        return new Squre();
    }
    public Squre walk(){
        System.out.println("Sqaure is walking");
        return this;
    }

    public Squre running(){
        System.out.println("Sqaure is running");
        return this;
    }
}

public class McqPractice {

    public static void main(String[] args) {

        Squre r = new Squre();
        System.out.println(r.walk().running().walk());
        System.out.println(r.area(5,4));
    }
}
