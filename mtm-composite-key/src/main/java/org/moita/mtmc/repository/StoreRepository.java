package org.moita.mtmc.repository;

import org.moita.mtmc.entity.StoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<StoreEntity, Long> {

    @Override
    List<StoreEntity> findAll();

    List<StoreEntity> findByNameIn(List<String> names);
    Optional<StoreEntity> findByName(String names);

//    @Override
//    <S extends StoreEntity> List<S> saveAll(Iterable<S> iterable);

}
