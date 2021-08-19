package org.moita.mtmc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.moita.mtmc.entity.GameEntity;
import org.moita.mtmc.entity.StoreEntity;
import org.moita.mtmc.entity.StoreGameEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    private Long id;
    private String name;
//    private List<String> stores;

    public static Game of(GameEntity e) {
        return Game.builder()
                .id(e.getId())
                .name(e.getName())
                // Optional for cases where a Game is being created
//                .stores(Optional.ofNullable(e.getStoreGames())
//                        .orElse(Collections.emptySet())
//                        .stream()
//                        .map(StoreGameEntity::getStore)
//                        .map(StoreEntity::getDescription)
//                        .collect(Collectors.toList()))
                .build();
    }
}
