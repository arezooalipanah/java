package ir.mapsa.firstspringproject.tutorials1;

import java.util.List;

public interface BaseStudentRepository {
    void add(Student student) throws Exception;

    void update(Student student) throws Exception;

    void removeById(Long id) throws Exception;
    Student findById(Long id) throws Exception;

    List<Student> getAll(Long id) throws Exception;
}
