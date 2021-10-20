package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    public static void closeQuietly(AutoCloseable recourse) {
        if (recourse != null) {
            try {
                recourse.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeQuietly(AutoCloseable... resources) {
        for (AutoCloseable t : resources) {
            closeQuietly(t);
        }
    }

    public static void rollbackQuietly(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
