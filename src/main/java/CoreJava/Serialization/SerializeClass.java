package CoreJava.Serialization;

import java.io.*;

public class SerializeClass {

    public static void main(String[] args) {

        EmployeeBean employeeBean = new EmployeeBean();

        employeeBean.setAge(40);
        employeeBean.setName("Khushali");

        FileOutputStream fileOutputStream = null;

        ObjectOutputStream objectOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream("EmployeeObj.txt");

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(employeeBean);

            System.out.println("Serialized!!!");

        }
        catch (IOException e) {
            System.out.println("catched! : " + e);
        }
        finally {

            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }





    }

}
