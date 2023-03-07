package taskone;

public class FrameworkWorkflow {

    public static void runner() {
        f();
        try {
            System.out.println("1");
            g(5);
            System.out.println("2");
            g(-4);
            System.out.println("3");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
        System.out.println("End");
    }

    private static void f() {
        System.out.println("salam");
    }

    private static void g(int x) throws Exception {
        if (x < 0) {
            throw new Exception("negative number");
        }
    }
}
