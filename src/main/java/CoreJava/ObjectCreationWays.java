package CoreJava;

import java.lang.reflect.InvocationTargetException;

class ClassA implements Cloneable {

    int number = 10;

    ClassA() {
        number = 10;
    }

    ClassA getInstance() {

        return this;

    }

    public int getNumber() {
        System.out.println(this.number);
        return number;

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void display() {
        System.out.println("Number : " + number);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /*public void callMain() throws CloneNotSupportedException {

        String[] args = {"hi", "Hello"};

        ObjectCreationWays objectCreationWays = new ObjectCreationWays();
        ObjectCreationWays.main(args);
    }*/

}

public class ObjectCreationWays {

    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException {

        ClassA objA = new ClassA();

        objA.setNumber(10);

        objA.display();

        System.out.println("First : " + objA);

        objA.setNumber(123);

        System.out.println("Object1 hash : " + objA.hashCode());

        ClassA objA2 = new ClassA();

        objA2 = objA;

        objA2.setNumber(321);

        System.out.println("obj2 : " +objA2.getNumber());

        System.out.println("obj1 : " + objA.getNumber());

        System.out.println("Object2 hash : " + objA2.hashCode());



//        objA.callMain();

        ClassA objCloned = (ClassA) objA.clone();
        objCloned.display();
        System.out.println("Second : " + objCloned);

        try {
            ClassA objByNewInstace = (ClassA) Class.forName("CoreJava.ClassA").newInstance();

            objByNewInstace.setNumber(200);
            objByNewInstace.getNumber();
            System.out.println("Third : " + objCloned);

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        /*try {
            ClassA objUsingConstrctor = ClassA.class.getConstructor().newInstance();
            objUsingConstrctor.setNumber(300);
            objUsingConstrctor.getNumber();
            System.out.println("Fourth : " + objCloned);

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
*/

        ClassA obj2 = objA;
        obj2.getNumber();
        System.out.println("First : " + objA);

        ClassA classInstance = objCloned.getInstance();
        classInstance.setNumber(400);
        classInstance.display();
        System.out.println("Instance : " + classInstance);
    }

}
