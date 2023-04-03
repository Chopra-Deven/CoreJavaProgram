package CoreJava.Exception;

class ThrowError
{

    public static void stackError()
    {

        throw new StackOverflowError();
        
    }

}

public class ErrorHandling
{

    public static void main(String[] args)
    {

        try
        {

            ThrowError.stackError();

        }
        catch (StackOverflowError error)
        {
            System.out.println(error);
        }

        System.out.println("Continuee...");


    }

}
