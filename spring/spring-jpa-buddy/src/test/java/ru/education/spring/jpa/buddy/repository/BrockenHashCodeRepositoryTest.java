package ru.education.spring.jpa.buddy.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.education.spring.jpa.buddy.entities.Comment;
import ru.education.spring.jpa.buddy.entities.Post;
import ru.education.spring.jpa.buddy.entities.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BrockenHashCodeRepositoryTest {

  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;

  @Test
  void userSetTest() {
    User user = new User();
    Set<User> set = new HashSet<>();

    set.add(user);
    userRepository.save(user);

    assertTrue(set.contains(user));
  }

  @Test
  void postSetTest() {
    Post post = new Post();
    Set<Post> set = new HashSet<>();

    set.add(post);
    postRepository.save(post);

    assertTrue(set.contains(post));
  }

  @Test
  void commentSetTest() {
    Comment comment = new Comment();
    Set<Comment> set = new HashSet<>();

    set.add(comment);
    commentRepository.save(comment);

    assertTrue(set.contains(comment));
  }
}