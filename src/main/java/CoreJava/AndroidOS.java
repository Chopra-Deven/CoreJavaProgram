package CoreJava;

abstract public class AndroidOS implements Requirements
{
    public static final int VERSION =10;

    public void notificationService(){
        System.out.println("No new Notifications");
    }

    public void bootUp(){
        System.out.println("Your phone is booting up");
    }

}
