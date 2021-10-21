package dao;

import exception.DaoSystemException;
import exception.NoSuchProductException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductDaoMock implements ProductDao {
    private Map<Integer, Product> map = new ConcurrentHashMap<Integer, Product>();

    public ProductDaoMock() {
        map.put(1, new Product(1,"Milk"));
        map.put(2, new Product(2,"Bread"));
        map.put(3, new Product(3,"Water"));
    }

    public Product selectById(Integer id) throws NoSuchProductException, DaoSystemException {
        if (!map.containsKey(id)) {
            throw new NoSuchProductException("No such product :" + id);
        }
        return map.get(id);
    }
    public List getAll() throws DaoSystemException {
        return new ArrayList<>(map.values());
    }
}
