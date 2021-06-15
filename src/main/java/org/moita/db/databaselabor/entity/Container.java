package org.moita.db.databaselabor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "container")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Container {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "metadata", joinColumns = @JoinColumn(name = "container_id"))
    @MapKeyColumn(name = "metadata_key")
    @Column(name = "metadata_value")
    private Map<String, String> metadata = new HashMap<>();
}
