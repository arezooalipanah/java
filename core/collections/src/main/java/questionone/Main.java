package questionone;

import questionone.timecomplexity.Base;
import questionone.timecomplexity.CalcTimeComplexity;
import questionone.timecomplexity.RecordCreator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Base base = new Base();
        base.setId(5_000_020);
        base.setName("name5000020");

        System.out.println("-------------------------------------arrayList");
        RecordCreator recordCreator = new RecordCreator(new ArrayList<>());
        CalcTimeComplexity calcTimeComplexity = new CalcTimeComplexity(recordCreator);
        System.out.println("arrayList add: " + calcTimeComplexity.add(recordCreator, base));
        System.out.println("arrayList contains: " + calcTimeComplexity.contains(recordCreator, base));
        System.out.println("arrayList remove: " + calcTimeComplexity.remove(recordCreator, base));

        System.out.println("-------------------------------------linkedList");
        recordCreator = new RecordCreator(new LinkedList<>());
        calcTimeComplexity = new CalcTimeComplexity(recordCreator);
        System.out.println("linkedList add: " + calcTimeComplexity.add(recordCreator, base));
        System.out.println("linkedList contains: " + calcTimeComplexity.contains(recordCreator, base));
        System.out.println("linkedList remove: " + calcTimeComplexity.remove(recordCreator, base));

        System.out.println("-------------------------------------hashSet");
        recordCreator = new RecordCreator(new HashSet<>());
        calcTimeComplexity = new CalcTimeComplexity(recordCreator);
        System.out.println("hashSet add: " + calcTimeComplexity.add(recordCreator, base));
        System.out.println("hashSet contains : " + calcTimeComplexity.contains(recordCreator, base));
        System.out.println("hashSet remove: " + calcTimeComplexity.remove(recordCreator, base));
    }
}
