package ru.education.spring.jpa.buddy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataHelper {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Transactional(rollbackFor = Exception.class)
  public void createAll() {
    jdbcTemplate.update("insert into users values (0)");
    jdbcTemplate.update("insert into post (id, user_id) values (0, 0)");
    jdbcTemplate.update("insert into comment (id, user_id) values (0, 0)");
  }
}