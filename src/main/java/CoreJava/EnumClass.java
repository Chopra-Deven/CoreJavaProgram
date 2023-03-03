package CoreJava;

enum Days{
    MONDAY,TUESDAY,WEDNESDAY;
    public static void main(String[] args) {
        System.out.println(Days.TUESDAY);
    }
}

public class EnumClass {

    public enum Seasons {WINTER,SUMMER;}

    public static void main(String[] args) {

        System.out.println(Seasons.SUMMER);
    }
}
