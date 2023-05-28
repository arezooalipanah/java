package generic.repository;

public interface Repository<T> {
    void add(T item);

    void add(T[] elements);

    T get(int index) throws InvalidIndexOrLineException;

    int find(T item);

    void shift(int index);

    void remove(int index) throws InvalidIndexOrLineException;

    void remove(T item) throws InvalidIndexOrLineException;

    void removeDuplicates(T item) throws InvalidIndexOrLineException;

    void update(int index, T item) throws InvalidIndexOrLineException;

    boolean contain(T item);

    void clear();

    void print();

}
