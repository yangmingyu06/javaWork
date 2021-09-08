/**
 * @(#)JdbcTest.java, 9月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.jdbc;

import mingyu.jdbc.data.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yangmingyu
 */
public class JdbcTest {

    private static String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";

    private static String JDBC_USER = "mingyu";

    private static String JDBC_PASSWORD = "yangmingyu23";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//            creatTest(connection);
//            searchTest(connection);
//            updateTest(connection);
//            deleteTest(connection);
//            final long l = creatTestPrepareStatement(connection);
//              searchTestPrepareStatement(connection);
//            updateTestPrepareStatement(connection);
//            deleteTestPrepareStatement(connection);
//            final long l = batchCreatTestPrepareStatement(connection);
            try {
                connection.setAutoCommit(false);
                creatTestPrepareStatement(connection);
                deleteTestPrepareStatement(connection);
                updateTestPrepareStatement(connection);
                connection.commit();
            } catch (SQLException s) {
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean creatTest(Connection c) {
        try (final Statement statement = c.createStatement()) {
            return statement.execute("INSERT INTO students (name, gender, grade, score) VALUES ('小坏蛋', 0, 3, 77)");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void searchTest(Connection c) {
        try (final Statement statement = c.createStatement()) {
            final ResultSet rs = statement
                    .executeQuery("SELECT id, grade, name, gender from students");
            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String name = rs.getString(3);
                int gender = rs.getInt(4);
                System.out.println(id + " " + grade + " " + name + " " + gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean updateTest(Connection c) {
        try (final Statement statement = c.createStatement()) {
            return statement.execute("UPDATE students SET name = '小怪兽' WHERE name = '小超人'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteTest(Connection c) {
        try (final Statement statement = c.createStatement()) {
            return statement.execute("DELETE FROM students WHERE name = '小怪兽'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long creatTestPrepareStatement (Connection c) {
        try (final PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, "larry");
            preparedStatement.setObject(2, 0);
            preparedStatement.setObject(3, 4);
            preparedStatement.setObject(4, 85);
            preparedStatement.executeUpdate();
            try (final ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long batchCreatTestPrepareStatement (Connection c) {
        try (final PreparedStatement ps = c.prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
            final Student a1 = new Student("a1", false, 3, 88);
            final Student a2 = new Student("a2", true, 4, 90);
            final Student[] students = new Student[2];
            students[0] = a1;
            students[1] = a2;
            for (Student s : students) {
                ps.setString(1, s.name);
                ps.setBoolean(2, s.gender);
                ps.setInt(3, s.grade);
                ps.setInt(4, s.score);
                ps.addBatch();
            }
            return ps.executeBatch().length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void searchTestPrepareStatement (Connection c) {
        try (final PreparedStatement preparedStatement = c.prepareStatement("SELECT id, grade, name, gender from students WHERE name = ?")){
            preparedStatement.setObject(1, "jack");
            final ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
                long grade = rs.getLong(2);
                String name = rs.getString(3);
                int gender = rs.getInt(4);
                System.out.println(id + " " + grade + " " + name + " " + gender);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean updateTestPrepareStatement (Connection c) {
        try (final PreparedStatement ps = c.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
            ps.setObject(1, "Bob"); // 注意：索引从1开始
            ps.setObject(2, 2);
            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteTestPrepareStatement (Connection c) {
        try (PreparedStatement ps = c.prepareStatement("DELETE FROM students WHERE id=?")) {
            ps.setObject(1, 1); // 注意：索引从1开始
            return ps.execute(); // 删除的行数
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}