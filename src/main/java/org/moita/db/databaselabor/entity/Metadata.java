package org.moita.db.databaselabor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metadata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metadata {

    @Id
    @Column(name = "container_id")
    private long containerId;
    @Column(name = "metadata_key")
    private String metadataKey;
    @Column(name = "metadata_value")
    private String metadataValue;
}
