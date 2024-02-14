package com.my.ddl.schema.repostiory;

import com.my.ddl.schema.entity.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntityRepository extends CrudRepository<Entity, UUID> {
    List<Entity> findByDbId(UUID dbId);
}
