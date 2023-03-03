package CoreJava.Generics;

public class CustomGen <T>{

    T obj;

    CustomGen(T obj){

        this.obj = obj;
    }

    public void show(){

        System.out.println("The type of Object is : " + obj.getClass().getName());
    }

    public T getObj(){

        return obj;
    }


}
