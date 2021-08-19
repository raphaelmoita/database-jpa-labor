package org.moita.mtmc.repository;

import org.moita.mtmc.entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Long> {

    @Override
    List<GameEntity> findAll();

    Optional<GameEntity> findByName(String name);
}
