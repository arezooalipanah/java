import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
//        System.out.println("hoooe");
//        Str str = new Str();
//        Convertor<String, Character> conv = str::startWith;
//        System.out.println(conv.convert("iii"));
//        Comparator<Integer> com = (a, b) -> a.compareTo(b);
//        System.out.println(com.compare(8, 10));
//        System.out.println(com.reversed().toString());
//        Predicate<Integer> pp = (x) -> x > 0;
//        System.out.println(pp.test(-5));
//        System.out.println(pp.negate().test(-89999));
//        Function<String, Integer> func =  Integer::valueOf;
//        Function<String, String> func2 = func.andThen(String::valueOf);


    }


}

@FunctionalInterface
interface Convertor<F, T> {
    T convert(F from);

}

class Str {
    Character startWith(String s) {
        return s.charAt(0);
    }
}