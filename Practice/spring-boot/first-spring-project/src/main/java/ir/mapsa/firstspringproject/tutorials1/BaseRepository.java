package ir.mapsa.firstspringproject.tutorials1;

import java.util.List;

public interface BaseRepository<T> {

    void add(T entity) throws Exception;

    void update(T entity)throws Exception;

    void removeById(Long id)throws Exception;

    T findById(Long id)throws Exception;

    List<T> getAll() throws Exception;

    List<T> findByExample(T e) throws Exception;
}
