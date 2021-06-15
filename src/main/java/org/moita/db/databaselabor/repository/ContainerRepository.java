package org.moita.db.databaselabor.repository;

import org.moita.db.databaselabor.entity.Container;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends CrudRepository<Container, Long> {
}
