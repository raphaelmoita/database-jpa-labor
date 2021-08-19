package org.moita.mtmc.repository;

import org.moita.mtmc.entity.StoreGameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreGameRepository extends CrudRepository<StoreGameEntity, Long> {

}
