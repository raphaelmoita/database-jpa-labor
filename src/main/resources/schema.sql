CREATE TABLE container (
    id INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE metadata (
    container_id INT NOT NULL,
    metadata_key VARCHAR(50) NOT NULL,
    metadata_value VARCHAR(255) NOT NULL,
    PRIMARY KEY (container_id, metadata_key)
);

ALTER TABLE metadata
    ADD FOREIGN KEY (container_id)
    REFERENCES container (id);