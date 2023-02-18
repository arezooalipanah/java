package dog;

public class Main {

    public static void main(String[] args) {
        // object creation / Instantiation
        Dog d = new Dog();

        // message passing / method invocation
        d.setName("Fido");
        d.bark();

        // reference type
        String s = new String("Ali");
        String t = new String("taghi");
        s = t;
        System.out.println(s);
    }
}
