package generic.repository.array;

import generic.repository.InvalidIndexOrLineException;

public interface ArrayRepository<T> {
    T[] slice(int from, int to);
}
