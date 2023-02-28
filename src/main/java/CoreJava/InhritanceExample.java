package CoreJava;

class Parent{

    Parent(){
        System.out.println("Parent const called");
    }

    Parent getInstance(){
        return this;
    }

    void display(){
        System.out.println("Class Parent");
    }

}

class Child extends Parent{

    Child(){
        super();
        System.out.println("Child const called");
    }

    Child getInstance(){
        return this;
    }

    void display(){
        System.out.println("class Child");
    }

}

class GrandChild extends Child{

    GrandChild getInstance(){
        return this;
    }

    void display(){
        System.out.println("GrandChild calling");
    }
}
public class InhritanceExample extends GrandChild{

    void display(){
        System.out.println("GrandChild calling");
    }

    public static void main(String[] args) {

        GrandChild grandChild = new GrandChild();
        Child child = new Child();

        grandChild.display();
        child.display();

        InhritanceExample inhritanceExample = new InhritanceExample();


    }

}
