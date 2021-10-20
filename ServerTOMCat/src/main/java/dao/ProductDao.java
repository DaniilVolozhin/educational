package dao;

import exception.DaoSystemException;
import exception.NoSuchProductException;

import java.util.List;

public interface ProductDao {
    Product selectById(Integer id) throws NoSuchProductException, DaoSystemException;

    List getAll() throws DaoSystemException;
}
