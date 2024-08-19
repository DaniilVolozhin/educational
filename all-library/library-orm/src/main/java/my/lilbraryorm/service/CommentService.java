package my.lilbraryorm.service;

import my.lilbraryorm.dao.CommentDao;
import my.lilbraryorm.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    public void save(Comment comment) {
        commentDao.save(comment);
    }

    public Comment update(Comment comment) {
        return commentDao.update(comment);
    }

    public void remove(long id) {
        commentDao.remove(id);
    }
}
