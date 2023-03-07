import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        // prevent sql injection
        PreparedStatement statement = connection.prepareStatement("select * from users where username=? and password=?");
        connection.setAutoCommit(false);
//        statement.setString(1, "Ali --");
//        statement.setString(2, "123");
//        ResultSet resultSet = statement.executeQuery();

        // unsafe way
//        Statement connectionStatement = connection.createStatement();
//        connectionStatement.executeQuery("select * from users");
//        while (resultSet.next()) {
//            // better because maybe column number changed
////            resultSet.getString("username");
//            System.out.println(resultSet.getString(2));
//        }
//        resultSet.close();
//        statement.close();
//        connection.close();

        long l = System.currentTimeMillis();
        // with insert
        PreparedStatement stm = connection.prepareStatement("insert into users(username, password) values(?,?)");
        Savepoint savepoint = null;
        for (int i = 0; i < 100; i++) {
            stm.setString(1, "ali" + i);
            stm.setString(2, "123" + i);
            stm.addBatch();
//            stm.executeUpdate();
            savepoint = connection.setSavepoint();
        }
        connection.rollback(savepoint);
//        stm.executeBatch();
//        connection.commit();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

        Main main = new Main();
        UserEntity user = new UserEntity();
        user.setUsername("someone");
        user.setPassword("123");
        main.insert(user);
//        user.setUsername("john_doe");
//        user.setPassword("1234");
//        user.setId(802L);
//        main.update(user);
//        main.deleteById(601L);
//        Optional<UserEntity> byId = main.findById(802L);
//        byId.ifPresent(i -> {
//            String str = "username is: " + i.getUsername() + " password is: " + i.getPassword();
//            System.out.println(str);
//        });
//        user.setUsername("ali");
//        List<UserEntity> userEntities = main.find(user);
//        System.out.println(userEntities.size());
        main.bulkUpdatePassword();

    }

    public void insert(UserEntity user) throws ClassNotFoundException, SQLException {
        if (user == null) {
            throw new IllegalArgumentException("user is null");
        }

        if (user.getPassword() == null || user.getUsername() == null) {
            throw new IllegalArgumentException("username or password is null");
        }
        Connection connection = getConnection();
        String insertQuery = "insert into users(username, password) values(?, ?)";
        PreparedStatement stm = connection.prepareStatement(insertQuery);
        stm.setString(1, user.getUsername());
        stm.setString(2, DigestUtils.sha1Hex(user.getPassword()));
        stm.executeUpdate();
        stm.close();
        connection.close();
    }

    public void update(UserEntity user) throws ClassNotFoundException, SQLException {
        if (user == null) {
            throw new IllegalArgumentException("user is null");
        }
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("password is null");
        }
        if (user.getUsername() == null) {
            throw new IllegalArgumentException("username is null");
        }
        if (user.getId() == null) {
            throw new IllegalArgumentException("id is null");
        }

        Connection connection = getConnection();
        String updateQuery = "update users set username=? , password=? where id=?";

        PreparedStatement stm = connection.prepareStatement(updateQuery);
        stm.setString(1, user.getUsername());
        stm.setString(2, DigestUtils.sha1Hex(user.getPassword()));
        stm.setLong(3, user.getId());
        stm.executeUpdate();
        stm.close();
        connection.close();
    }

    public void deleteById(Long id) throws ClassNotFoundException, SQLException {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        Connection connection = getConnection();
        String deleteQuery = "delete from users where id=?";
        PreparedStatement stm = connection.prepareStatement(deleteQuery);
        stm.setLong(1, id);
        stm.executeUpdate();
        stm.close();
        connection.close();
    }

    public Optional<UserEntity> findById(Long id) throws ClassNotFoundException, SQLException {
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        }

        Connection connection = getConnection();

        String findQuery = "select * from users where id=?;";

        PreparedStatement stm = connection.prepareStatement(findQuery);
        stm.setLong(1, id);
        ResultSet resultSet = stm.executeQuery();
        while (resultSet.next()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(id);
            userEntity.setPassword(resultSet.getString("password"));
            userEntity.setUsername(resultSet.getString("username"));
            return Optional.of(userEntity);
        }
        return Optional.empty();
    }

    public List<UserEntity> find(UserEntity entity) throws ClassNotFoundException, SQLException {
        if (entity == null) {
            throw new IllegalArgumentException("entity is null");
        }

        Connection connection = getConnection();
        String findQuery;
        PreparedStatement stm;
        if (entity.getUsername() != null) {
            findQuery = "select * from users where username like ? ESCAPE '!';";
            stm = connection.prepareStatement(findQuery);
            stm.setString(1, "%" + entity.getUsername() + "%");
        } else if (entity.getId() != null) {
            findQuery = "select * from users where id=?;";
            stm = connection.prepareStatement(findQuery);
            stm.setLong(1, entity.getId());
        } else {
            findQuery = "select * from users;";
            stm = connection.prepareStatement(findQuery);
        }
        ResultSet resultSet = stm.executeQuery();
        List<UserEntity> result = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(resultSet.getLong("id"));
            userEntity.setPassword(resultSet.getString("password"));
            userEntity.setUsername(resultSet.getString("username"));
            result.add(userEntity);
        }
        return result;
    }

    public void bulkUpdatePassword() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users;");
        String query = "update users set password=? where id=?";
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        while (resultSet.next()) {

            String password = resultSet.getString("password");
            if (resultSet.isLast()) {
                continue;
            }
            prepareStatement.setString(1,DigestUtils.sha256Hex(password));
            prepareStatement.setLong(2,resultSet.getLong("id"));
            prepareStatement.executeUpdate();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        return connection;
    }

}
