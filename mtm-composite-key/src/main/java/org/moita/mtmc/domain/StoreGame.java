package org.moita.mtmc.domain;

import lombok.*;
import org.moita.mtmc.entity.GameEntity;
import org.moita.mtmc.entity.StoreEntity;
import org.moita.mtmc.entity.StoreGameEntityKey;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StoreGame {

    private String game;
    private String store;
    private Double price;
}
