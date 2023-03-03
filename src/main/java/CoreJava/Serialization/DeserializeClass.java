package CoreJava.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeClass {

    public static void main(String[] args) {

        EmployeeBean empBean = null;

        try {

            FileInputStream fileInputStream = new FileInputStream("EmployeeObj.txt");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            empBean = (EmployeeBean) objectInputStream.readObject();

            fileInputStream.close();

            objectInputStream.close();

            System.out.println("Employee Name : " + empBean.getName());

            System.out.println("Employee Age : " + empBean.getAge());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
