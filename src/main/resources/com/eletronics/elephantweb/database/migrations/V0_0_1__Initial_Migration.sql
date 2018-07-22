CREATE TABLE configuration (
  id          INTEGER PRIMARY KEY AUTOINCREMENT,
  name        VARCHAR NOT NULL UNIQUE,
  value       TEXT,
  editable    BOOLEAN
);

INSERT INTO configuration (name, value, editable) VALUES
 ('version', '1.0.0', 0);