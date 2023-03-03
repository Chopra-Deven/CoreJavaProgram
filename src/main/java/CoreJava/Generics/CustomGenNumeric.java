package CoreJava.Generics;

// it is called bounded type in which only numeric object will be accepted only. It is used to restrict to use only numbers

//public class CustomGenNumeric <T extends Integer & Runnable>{

public class CustomGenNumeric <T extends Integer>{

    T obj;

    CustomGenNumeric(T obj){

        this.obj = obj;
    }

    public void show(){

        System.out.println("The type of Object is : " + obj.getClass().getName());
    }

    public T getObj(){

        return obj;
    }


}
