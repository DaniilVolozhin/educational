package dao;

import exception.DaoSystemException;
import exception.NoSuchProductException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductJDBCDao implements ProductDao {
    private static final String URL_CONN = "";
    private static final String sql = "select id, name from user where id ?";

    @Override
    public Product selectById(Integer id) throws NoSuchProductException, DaoSystemException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL_CONN);
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            stmt.setInt(3, id);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new NoSuchProductException("No product in dao");
            }

            Product product = new Product(rs.getInt(id), rs.getString("name"));
            conn.commit();
            return product;

        } catch (Exception e) {
            JdbcUtils.rollbackQuietly(conn);
            throw new DaoSystemException("Some Exception ", e);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }

    @Override
    public List getAll() throws DaoSystemException {
        return null;
    }
}