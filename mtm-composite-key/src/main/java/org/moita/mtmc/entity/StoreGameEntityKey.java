package org.moita.mtmc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StoreGameEntityKey implements Serializable {

    @Column(name = "store_id")
    public Long storeId;

    @Column(name = "game_id")
    public Long gameId;
}
