package org;

import org.entities.BonusEntity;
import org.entities.TitleEntity;
import org.entities.WorkerEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ORG {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/org", "root", "root");
        return connection;
    }

    public static void addWorker(WorkerEntity workerEntity) throws SQLException {
        if (workerEntity == null) {
            throw new IllegalArgumentException("worker is null");
        }
        String insertQuery = "INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES (?,?,?,?,?,?);";
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setInt(1, workerEntity.getWORKER_ID());
                statement.setString(2, workerEntity.getFIRST_NAME());
                statement.setString(3, workerEntity.getLAST_NAME());
                statement.setInt(4, workerEntity.getSALARY());
                statement.setDate(5, workerEntity.getJOINING_DATE());
                statement.setString(6, workerEntity.getDEPARTMENT());
                statement.executeUpdate();
            }
        }
    }

    public static void addBonus(BonusEntity bonusEntity) throws SQLException {
        if (bonusEntity == null) {
            throw new IllegalArgumentException("bonus is null");
        }

        String insertQuery = "INSERT INTO Bonus (WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES (?,?,?)";
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setInt(1, bonusEntity.getWORKER_REF_ID());
                statement.setInt(2, bonusEntity.getBONUS_AMOUNT());
                statement.setDate(3, bonusEntity.getBONUS_DATE());
                statement.executeUpdate();
            }
        }
    }

    public static void addTitle(TitleEntity titleEntity) throws SQLException {
        if (titleEntity == null) {
            throw new IllegalArgumentException("title is null");
        }

        String insertQuery = "INSERT INTO Title (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES(?,?,?)";
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setInt(1, titleEntity.getWORKER_REF_ID());
                statement.setString(2, titleEntity.getWORKER_TITLE());
                statement.setDate(3, titleEntity.getAFFECTED_FROM());
                statement.executeUpdate();
            }
        }
    }

    private static WorkerEntity getWorker(ResultSet resultSet) throws SQLException {
        WorkerEntity worker = new WorkerEntity();
        worker.setWORKER_ID(resultSet.getInt("WORKER_ID"));
        worker.setFIRST_NAME(resultSet.getString("FIRST_NAME"));
        worker.setLAST_NAME(resultSet.getString("LAST_NAME"));
        worker.setSALARY(resultSet.getInt("SALARY"));
        worker.setJOINING_DATE(resultSet.getDate("JOINING_DATE"));
        worker.setDEPARTMENT(resultSet.getString("DEPARTMENT"));
        return worker;
    }

    private static TitleEntity getTitle(ResultSet resultSet) throws SQLException {
        TitleEntity title = new TitleEntity();
        title.setWORKER_REF_ID(resultSet.getInt("WORKER_REF_ID"));
        title.setWORKER_TITLE(resultSet.getString("WORKER_TITLE"));
        title.setAFFECTED_FROM(resultSet.getDate("AFFECTED_FROM"));
        return title;
    }

    private static List<WorkerEntity> retrieveAllWorker(String query) throws SQLException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<WorkerEntity> result = new ArrayList<>();
                    while (resultSet.next()) {
                        WorkerEntity worker = getWorker(resultSet);
                        result.add(worker);
                    }
                    return result;
                }
            }
        }
    }

    public static List<WorkerEntity> questionOne() throws SQLException {
        return retrieveAllWorker("SELECT *\n" +
                "FROM Worker\n" +
                "WHERE YEAR(JOINING_DATE) = 2014\n" +
                "  AND MONTH(JOINING_DATE) = 2;");
    }

    public static List<TitleEntity> questionTwo() throws SQLException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT WORKER_TITLE, AFFECTED_FROM, COUNT(*) AS COUNT\n" +
                    "FROM Title\n" +
                    "GROUP BY WORKER_TITLE, AFFECTED_FROM\n" +
                    "HAVING COUNT > 1")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<TitleEntity> result = new ArrayList<>();
                    while (resultSet.next()) {
                        TitleEntity title = new TitleEntity();
                        title.setWORKER_TITLE(resultSet.getString("WORKER_TITLE"));
                        title.setAFFECTED_FROM(resultSet.getDate("AFFECTED_FROM"));
                        title.setAGGREGATE(resultSet.getInt("COUNT"));
                        result.add(title);
                    }
                    return result;
                }
            }
        }
    }

    public static List<WorkerEntity> questionFour() throws SQLException {
        return retrieveAllWorker("SELECT w.*\n" +
                "FROM Worker as w\n" +
                "         INNER JOIN update_worker uw on w.WORKER_ID = uw.WORKER_ID;");
    }

    public static List<WorkerEntity> questionFive() throws SQLException {
        return retrieveAllWorker("SELECT *\n" +
                "FROM update_worker AS uw\n" +
                "WHERE NOt EXISTS(SELECT * FROM Worker AS w WHERE uw.WORKER_ID = w.WORKER_ID)");
    }

    public static List<WorkerEntity> questionSix() throws SQLException {
        return retrieveAllWorker("SELECT *\n" +
                "FROM Worker\n" +
                "ORDER BY SALARY DESC\n" +
                "    LIMIT 4,1;");
    }

    public static List<WorkerEntity> questionSeven() throws SQLException {
        return retrieveAllWorker("SELECT *\n" +
                "FROM (SELECT *, NTILE(2) OVER (ORDER BY null) nt FROM Worker) AS t\n" +
                "WHERE nt = 1;");
    }


    public static List<WorkerEntity> questionٔEight() throws SQLException {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT DEPARTMENT, COUNT(*) AS COUNT \n" +
                    "FROM Worker\n" +
                    "GROUP BY DEPARTMENT\n" +
                    "HAVING COUNT(*) < 5;")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<WorkerEntity> result = new ArrayList<>();
                    while (resultSet.next()) {
                        WorkerEntity worker = new WorkerEntity();
                        worker.setAGGREGATE(resultSet.getInt("COUNT"));
                        worker.setDEPARTMENT(resultSet.getString("DEPARTMENT"));
                        result.add(worker);
                    }
                    return result;
                }
            }
        }
    }


    public static List<WorkerEntity> questionٔNine() throws SQLException {
        return retrieveAllWorker("SELECT *\n" +
                "FROM Worker\n" +
                "WHERE SALARY IN (\n" +
                "    SELECT MAX(SALARY)\n" +
                "    FROM Worker\n" +
                "    GROUP BY DEPARTMENT\n" +
                ") ORDER BY SALARY DESC;");
    }

}
