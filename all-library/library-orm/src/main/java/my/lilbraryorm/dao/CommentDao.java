package my.lilbraryorm.dao;

import my.lilbraryorm.entity.Comment;

public interface CommentDao {
    void save(Comment t);

    Comment update(Comment t);

    void remove(long id);
}