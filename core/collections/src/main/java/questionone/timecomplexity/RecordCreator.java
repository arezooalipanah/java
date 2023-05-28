package questionone.timecomplexity;

import java.util.Collection;

public class RecordCreator {
    private int recordsSize = 5_000_000;
    private final Collection<Base> collection;

    public RecordCreator(Collection<Base> collectionType) {
        collection = collectionType;
    }

    public RecordCreator(int recordsSize, Collection<Base> collectionType) {
        this.recordsSize = recordsSize;
        collection = collectionType;
    }

    public void create() {
        for (int i = 0; i < this.recordsSize; i++) {
            collection.add(new Base(i, "name" + i));
        }
    }

    public Collection<Base> getCollection() {
        return collection;
    }
}
