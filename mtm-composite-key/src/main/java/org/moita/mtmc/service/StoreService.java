package org.moita.mtmc.service;

import org.moita.mtmc.domain.Game;
import org.moita.mtmc.domain.Store;
import org.moita.mtmc.domain.StoreGame;
import org.moita.mtmc.entity.GameEntity;
import org.moita.mtmc.entity.StoreEntity;
import org.moita.mtmc.repository.GameRepository;
import org.moita.mtmc.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreService {

    private StoreRepository storeRepository;
    private GameRepository gameRepository;
    private StoreGameService storeGameService;

    @Autowired
    public StoreService(StoreRepository storeRepository,
                        GameRepository gameRepository,
                        StoreGameService storeGameService) {
        this.storeRepository = storeRepository;
        this.gameRepository = gameRepository;
        this.storeGameService = storeGameService;
    }

    public Store findById(Long id) {
        return Store.of(storeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("not found")));
    }

    public List<Store> findAll() {
        return storeRepository.findAll()
                .stream()
                .map(Store::of)
                .collect(Collectors.toList());
    }

    public Store save(Store store) {
        StoreEntity e = StoreEntity.of(store);
        return Store.of(storeRepository.save(e));
    }

    @Transactional
    public Store addGame(StoreGame storeGame) {
        String game = storeGame.getGame();
        String store = storeGame.getStore();

        StoreEntity storeEntity = storeRepository.findByName(store)
            .orElseThrow(() -> new IllegalStateException(game + " not found"));;

        GameEntity gameEntity = gameRepository.findByName(storeGame.getGame())
            .orElseThrow(() -> new IllegalStateException(game + " not found"));

        storeEntity.addGame(gameEntity, storeGame.getPrice());

        return Store.of(storeRepository.save(storeEntity));
    }
}
