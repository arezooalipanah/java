package generic.repository.array;

import generic.repository.InvalidIndexOrLineException;
import generic.repository.Repository;
import generic.shared.Base;

public class GenericArrayRepository<T extends Base> implements Repository<T>, ArrayRepository<T> {
    private Base[] elements;
    private int emptyIndex = 0;
    private final static int size = 5;

    public GenericArrayRepository() {
        this.elements = new Base[100];
    }

    public GenericArrayRepository(int size) {
        this.elements = new Base[size];
    }

    public GenericArrayRepository(GenericArrayRepository<T> repo) {
        this.elements = repo.elements;
    }

    // add
    private void extendArray() {
        Base[] extendedArray = new Base[elements.length + size];
        int index = 0;

        for (Base element : elements) {
            extendedArray[index++] = element;
        }
        this.elements = extendedArray;
    }

    @Override
    public void add(T element) {
        if (element != null) {
            if (emptyIndex >= elements.length) {
                extendArray();
            }
            elements[emptyIndex++] = element;
        }
    }

    @Override
    public void add(T[] inputs) {
        if (inputs != null) {
            for (T input : inputs) {
                add(input);
            }
        }
    }

    // get
    private boolean isInValidIndex(int index) {
        return index < 0 || index >= elements.length;
    }

    @Override
    public T get(int index) throws InvalidIndexOrLineException {
        if (isInValidIndex(index)) {
            throw new InvalidIndexOrLineException(String.format("Invalid index%d", index));
        }
        return (T) elements[index];
    }

    public T getById(Long id) {
        for (Base element : elements) {
            if (element != null && element.getId().equals(id)) {
                return (T) element;
            }
        }
        return null;
    }

    // find
    @Override
    public int find(T element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int findById(Long id) {
        if (id == null) {
            return -1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // remove
    @Override
    public void shift(int index) {
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--emptyIndex] = null;
    }

    @Override
    public void remove(int index) throws InvalidIndexOrLineException {
        if (isInValidIndex(index)) {
            throw new InvalidIndexOrLineException(String.format("Invalid index%d", index));
        }
        elements[index] = null;
        shift(index);
    }

    @Override
    public void remove(T element) throws InvalidIndexOrLineException {
        int index = find(element);
        if (index == -1) {
            throw new InvalidIndexOrLineException(String.format("Invalid index%d", -1));
        }
        remove(index);
    }

    @Override
    public void removeDuplicates(T element) throws InvalidIndexOrLineException {
        if (element != null) {
            for (int i = 0; i < elements.length; i++) {
                remove(element);
            }
        }
    }

    // update
    @Override
    public void update(int index, T element) throws InvalidIndexOrLineException {
        if (isInValidIndex(index)) {
            throw new InvalidIndexOrLineException(String.format("Invalid index%d", index));
        }
        elements[index] = element;
    }

    // -----clear && contain && sub-elements && print-----
    @Override
    public void clear() {
        elements = new Base[size];
        emptyIndex = 0;
    }

    public boolean contain(Long id) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contain(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // sub-elements
    @Override
    public T[] slice(int from, int to) {
        if (from < 0 || from > to || to >= elements.length) {
            throw new NullPointerException();
        }
        Base[] subElements = new Base[to - from + 1];
        int index = 0;
        for (int i = from; i <= to; i++) {
            subElements[index++] = elements[i];
        }

        return (T[]) subElements;
    }

    public GenericArrayRepository<T> subElements(int from, int to) {
        if (from < 0 || from > to || to >= elements.length) {
            return null;
        }
        GenericArrayRepository<T> genericArrayRepository = new GenericArrayRepository<>();
        Base[] temp = new Base[to - from + 1];
        int index = 0;
        for (int i = from; i <= to; i++) {
            temp[index++] = elements[i];
        }
        genericArrayRepository.elements = temp;
        return genericArrayRepository;
    }

    // print
    @Override
    public void print() {
        for (Base element : elements) {
            if (element != null) {
                System.out.println(element.getId());
            }
        }
    }

}
