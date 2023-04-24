public class infiniteArgs {
    public static void main(String[] args)
    {
        printArgs("foo", "bar" , "5");

    }
    public static void printArgs(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }

    }

}