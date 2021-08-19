package org.moita.mtmc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.moita.mtmc.entity.StoreEntity;
import org.moita.mtmc.entity.StoreGameEntity;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    private Long id;
    private String description;
    private Map<String, Double> gamePriceMap;

    public static Store of(StoreEntity e) {
        return Store.builder()
                .id(e.getId())
                .description(e.getName())
                // Optional for cases where a Store is being created
                .gamePriceMap(Optional.ofNullable(e.getStoreGames())
                        .orElse(Collections.emptySet())
                        .stream()
                        .collect(toMap(sg -> sg.getGame().getName(), StoreGameEntity::getPrice)))
                .build();
    }
}
