package org.moita.mtmc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.moita.mtmc.domain.Store;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Arrays.asList;

@Entity
@Table(name = "store")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "store", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<StoreGameEntity> storeGames = new HashSet<>();

    public void addGame(GameEntity game, Double price) {
        StoreGameEntity storeGameEntity = StoreGameEntity.builder()
                .game(game)
                .store(this)
                .price(price)
                .build();

        storeGames.add(storeGameEntity);
    }

    public void removeGame(GameEntity game) {
        storeGames.removeIf(s -> s.getGame().getId().equals(game.getId()));
    }

    public static StoreEntity of(Store e) {
        return StoreEntity.builder()
                .id(e.getId())
                .name(e.getDescription())
                .build();
    }
}
