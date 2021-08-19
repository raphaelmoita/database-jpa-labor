package org.moita.mtmc.service;

import org.moita.mtmc.entity.GameEntity;
import org.moita.mtmc.entity.StoreEntity;
import org.moita.mtmc.entity.StoreGameEntity;
import org.moita.mtmc.entity.StoreGameEntityKey;
import org.moita.mtmc.repository.StoreGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreGameService {

    private StoreGameRepository storeGameRepository;

    @Autowired
    public StoreGameService(StoreGameRepository storeGameRepository) {
        this.storeGameRepository = storeGameRepository;
    }

    public StoreGameEntity addGame(StoreEntity store, GameEntity game) {
        return storeGameRepository.save(StoreGameEntity.builder()
            .id(StoreGameEntityKey.builder()
                    .storeId(store.getId())
                    .gameId(game.getId())
                    .build())
            .game(game)
            .store(store)
            .build());
    }
}
