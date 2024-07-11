package ru.education.spring.jpa.buddy.repository;

import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.education.spring.jpa.buddy.entities.User;

@Transactional
@SpringBootTest
class LazyAssociationRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private DataHelper dataHelper;
  private final PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

  @BeforeEach
  public void save() {
    dataHelper.createAll();
  }

  @Test
  void toStringLazyTest() {
    User user = userRepository.findById(0L).orElseThrow();
    Assertions.assertFalse(persistenceUtil.isLoaded(user.getPosts()));

    String s = user.toString();
    Assertions.assertFalse(persistenceUtil.isLoaded(user.getPosts()));
  }

  @Test
  void toStringExcludeLazyTest() {
    User user = userRepository.findById(0L).orElseThrow();
    Assertions.assertFalse(persistenceUtil.isLoaded(user.getComments()));

    String s = user.toString();
    Assertions.assertFalse(persistenceUtil.isLoaded(user.getComments()));
  }
}