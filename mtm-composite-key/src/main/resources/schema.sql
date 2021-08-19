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


-- MANY TO MANY

CREATE TABLE store (
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE game (
    id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE store_game (
    store_id INT NOT NULL,
    game_id INT NOT NULL,
    price DECIMAL NOT NULL,
    PRIMARY KEY (store_id, game_id),
    CONSTRAINT fk_store_game_store_id
        FOREIGN KEY (store_id)
        REFERENCES store (id),
    CONSTRAINT fk_store_game_game_id
        FOREIGN KEY (game_id)
        REFERENCES game (id)
);