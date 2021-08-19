package org.moita.mtmc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.moita.mtmc.domain.Game;
import org.moita.mtmc.domain.Store;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "game")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "game")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<StoreGameEntity> storeGames = new HashSet<>();

    public static GameEntity of(Game e) {
        return GameEntity.builder()
                .id(e.getId())
                .name(e.getName())
                .build();
    }
}
