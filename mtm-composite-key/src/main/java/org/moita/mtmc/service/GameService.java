package org.moita.mtmc.service;

import org.moita.mtmc.domain.Game;
import org.moita.mtmc.entity.GameEntity;
import org.moita.mtmc.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game findById(Long id) {
        return Game.of(gameRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "not found")));
    }

    public List<Game> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(Game::of)
                .collect(Collectors.toList());
    }

    public Game save(Game game) {
        GameEntity e = GameEntity.of(game);
        return Game.of(gameRepository.save(e));
    }
}
