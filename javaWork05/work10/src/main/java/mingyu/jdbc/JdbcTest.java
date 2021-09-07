/**
 * @(#)JdbcTest.java, 9月 07, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package mingyu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
            creatTest(connection);
            searchTest(connection);
            updateTest(connection);
            deleteTest(connection);
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
}