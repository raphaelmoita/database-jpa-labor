package org.moita.db.databaselabor.repository;

import org.moita.db.databaselabor.entity.Metadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends CrudRepository<Metadata, Long> {
}
