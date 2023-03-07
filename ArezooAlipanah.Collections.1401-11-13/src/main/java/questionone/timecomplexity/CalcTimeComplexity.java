package questionone.timecomplexity;

public class CalcTimeComplexity {

    public CalcTimeComplexity(RecordCreator recordCreator) {
        recordCreator.create();
        System.out.println("collection size before add is: " + recordCreator.getCollection().size());
    }

    public long add(RecordCreator recordCreator, Base item) {
        long beforeAdd = System.currentTimeMillis();
        recordCreator.getCollection().add(item);
        System.out.println("collection size after add is: " + recordCreator.getCollection().size());
        return System.currentTimeMillis() - beforeAdd;
    }

    public long contains(RecordCreator recordCreator, Base item) {
        long beforeContains = System.currentTimeMillis();
        recordCreator.getCollection().contains(item);
        return System.currentTimeMillis() - beforeContains;
    }

    public long remove(RecordCreator recordCreator, Base item) {
        long beforeRemove = System.currentTimeMillis();
        recordCreator.getCollection().remove(item);
        return System.currentTimeMillis() - beforeRemove;
    }
}

