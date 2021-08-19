package org.moita.mtmc.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "store_game")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StoreGameEntity {

    @EmbeddedId
    private StoreGameEntityKey id = new StoreGameEntityKey();

    @ManyToOne
    @MapsId("storeId")
    @JoinColumn(name = "store_id")
    private StoreEntity store;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private GameEntity game;

    private Double price;
}
