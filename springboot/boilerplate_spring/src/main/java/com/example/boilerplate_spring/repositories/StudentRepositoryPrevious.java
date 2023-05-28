package com.example.boilerplate_spring.repositories;

import com.example.boilerplate_spring.exceptions.IdNotFoundException;
import com.example.boilerplate_spring.exceptions.ServiceException;
import com.example.boilerplate_spring.models.StudentEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRepositoryPrevious implements BaseRepository<StudentEntity> {
    public void executeUpdateQuery(String query, StudentEntity student) throws ServiceException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, student.getPassedCourse());
                statement.setString(2, student.getName());
                statement.setString(3, student.getStudentId());
                statement.setString(4, student.getNationalCode());
                statement.setString(5, student.getFamily());
                if (student.getId() != null) {
                    statement.setLong(6, student.getId());
                }
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new ServiceException("Error in creating connection", e, "database-exception");
        }
    }

    @Override
    public void add(StudentEntity student) throws ServiceException {
        executeUpdateQuery("insert into db.student(" +
                "passed_course, name, student_id, national_code, family)\n" +
                "values (?,?,?,?,?);", student);
    }

    @Override
    public void update(StudentEntity student) throws ServiceException {
        executeUpdateQuery("update db.student set passed_course=?, name=?, student_id=?, national_code=?, family=? where id=?", student);
    }

    @Override
    public void removeById(Long id) throws ServiceException {
        if (this.findById(id) == null) {
            throw new IdNotFoundException("student-notFound");
        }
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("delete from db.student where id=?")) {
                statement.setLong(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new ServiceException("Error in creating connection", e, "database-exception");
        }
    }

    @Override
    public StudentEntity findById(Long id) throws ServiceException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("select * from db.student where id=?")) {
                statement.setLong(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        StudentEntity student = getStudent(resultSet);
                        return student;
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new ServiceException("Error in creating connection", e, "database-exception");
        }
    }


    private static StudentEntity getStudent(ResultSet resultSet) throws SQLException {
        StudentEntity student = new StudentEntity();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setFamily(resultSet.getString("family"));
        student.setPassedCourse(resultSet.getInt("passed_course"));
        student.setStudentId(resultSet.getString("student_id"));
        student.setNationalCode(resultSet.getString("national_code"));
        return student;
    }

    @Override
    public List<StudentEntity> getAll() throws ServiceException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("select * from db.student")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<StudentEntity> list = new ArrayList<>();
                    while (resultSet.next()) {
                        StudentEntity student = getStudent(resultSet);
                        list.add(student);
                    }
                    return list;
                }
            }
        } catch (SQLException e) {
            throw new ServiceException("Error in creating connection", e, "database-exception");
        }
    }

    public List<StudentEntity> findByExample(StudentEntity student) throws ServiceException {
        String query = "select * from db.student where 1=1";
        if (student.getId() != null) {
            query += " AND id=" + student.getId();
        }

        if (student.getNationalCode() != null) {
            query += " AND national_code= '" + student.getNationalCode() + "'";
        }

        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<StudentEntity> result = new ArrayList<>();
                    while (resultSet.next()) {
                        StudentEntity student1 = getStudent(resultSet);
                        result.add(student1);
                    }
                    return result;
                }

            }

        } catch (SQLException e) {
            throw new ServiceException("Error in creating connection", e, "database-exception");
        }
    }

    public Connection getConnection() throws ServiceException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
            return connection;
        } catch (Exception e) {
            throw new ServiceException("Error in creating connection", e, "database-exception");
        }

    }
}
