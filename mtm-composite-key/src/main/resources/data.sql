INSERT INTO container (id, description) VALUES (1, 'C1');
INSERT INTO container (id, description) VALUES (2, 'C2');
INSERT INTO container (id, description) VALUES (3, 'C3');

INSERT INTO metadata (container_id, metadata_key, metadata_value) VALUES (1, 'DATA', '20201231');
INSERT INTO metadata (container_id, metadata_key, metadata_value) VALUES (1, 'HASH', 'hga6t7a657a657');
INSERT INTO metadata (container_id, metadata_key, metadata_value) VALUES (2, 'RESET', '01');
INSERT INTO metadata (container_id, metadata_key, metadata_value) VALUES (3, 'DATA', '19770531');

-- MANY TO MANY
INSERT INTO game (id, name) VALUES (1, 'Street Fighter');
INSERT INTO game (id, name) VALUES (2, 'Mortal kombat');
INSERT INTO game (id, name) VALUES (3, 'Mario Bros');
INSERT INTO game (id, name) VALUES (4, 'Guilt Gear Strive');

INSERT INTO store (id, name) VALUES (1, 'Amazon');
INSERT INTO store (id, name) VALUES (2, 'Submarino');

INSERT INTO store_game (store_id, game_id, price) VALUES (1, 1, 1000);
INSERT INTO store_game (store_id, game_id, price) VALUES (1, 2, 1220);
INSERT INTO store_game (store_id, game_id, price) VALUES (1, 3, 879);
INSERT INTO store_game (store_id, game_id, price) VALUES (2, 1, 999);