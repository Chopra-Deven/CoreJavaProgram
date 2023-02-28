package CoreJava;

public interface Requirements {

    default void calling(){
        System.out.println("Calling to person");
    }

    void charging();

    void message();

}
