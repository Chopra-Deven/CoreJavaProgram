package CoreJava.Exception;

class UserDefinedException extends Exception
{
    public UserDefinedException(String str)
    {
        // Calling constructor of parent Exception
        super(str);
    }
}
// Class that uses above MyException
class TestThrow3
{
    public static void main(String args[]) throws InterruptedException {
        try
        {
            // throw an object of user defined exception

            throw new UserDefinedException("This is user-defined exception");

        }

        catch (UserDefinedException ude)
        {

            System.out.println("Caught the exception");

            // Print the message from MyException object

            System.out.println(ude.getMessage());
        }

        System.out.println("Other code");

//        Thread.sleep(5000);

        System.out.println("Other code...........");

        try{
            System.out.println("inside try");
        } catch (Exception e) {
            System.out.println("inside catch");
        }
        finally {
            System.out.println("inside finnaly");
        }

    }
}
