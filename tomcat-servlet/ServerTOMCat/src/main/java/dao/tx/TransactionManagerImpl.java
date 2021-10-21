package dao.tx;

import dao.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.Callable;

public class TransactionManagerImpl extends BaseDataSource implements TransactionManager {
    private static final String URL_CONN = "";

    public static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    @Override
    public <T> T doInTransaction(Callable<T> unitOfWorks) throws Exception {
        Connection conn = DriverManager.getConnection(URL_CONN);
        conn.setAutoCommit(false);
        connectionHolder.set(conn);
        try {
            T result = unitOfWorks.call();
            conn.commit();
            return result;
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JdbcUtils.closeQuietly(conn);
            connectionHolder.remove();
        }
    }
}