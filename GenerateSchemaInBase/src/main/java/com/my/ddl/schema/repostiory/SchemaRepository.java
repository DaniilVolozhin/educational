package com.my.ddl.schema.repostiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.my.ddl.schema.entity.Schema;

import java.util.UUID;

@Repository
public interface SchemaRepository extends CrudRepository<Schema, UUID> {
}
