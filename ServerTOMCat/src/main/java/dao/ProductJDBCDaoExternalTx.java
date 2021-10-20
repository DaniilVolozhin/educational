package dao;

import dao.tx.DataSource;
import exception.DaoSystemException;
import exception.NoSuchProductException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductJDBCDaoExternalTx implements ProductDao {
    private static final String URL_CONN = "";
    private static final String sql = "select id, name from user where id ?";

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Product selectById(Integer id) throws NoSuchProductException, DaoSystemException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Connection conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new NoSuchProductException("No product in dao");
            }

            return new Product(rs.getInt(id), rs.getString("name"));

        } catch (Exception e) {
            throw new DaoSystemException("Some Exception ", e);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt);
        }
    }

    public List getAll() throws DaoSystemException {
        return null;
    }
}
