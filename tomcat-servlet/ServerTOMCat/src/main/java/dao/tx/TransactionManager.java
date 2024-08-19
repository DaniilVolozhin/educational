package dao.tx;

import java.util.concurrent.Callable;

public interface TransactionManager {
    public <T> T doInTransaction(Callable<T> unitOfWorks) throws Exception;
}
