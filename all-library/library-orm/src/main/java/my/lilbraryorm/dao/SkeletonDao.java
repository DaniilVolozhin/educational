package my.lilbraryorm.dao;

import java.util.List;

public interface SkeletonDao<T> {
    List<T> get();
    T getById(long id);

    void save(T t);

    T update(T t);

    void remove(long id);
}
