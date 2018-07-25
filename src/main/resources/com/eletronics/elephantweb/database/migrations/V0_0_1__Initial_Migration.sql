CREATE TABLE configuration (
  id          int(11)      NOT NULL AUTO_INCREMENT,
  name        varchar(100) NOT NULL,
  value       varchar(300),
  description varchar(300)          DEFAULT NULL,
  editable    BOOLEAN               DEFAULT TRUE,
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

INSERT INTO configuration (name, value, description, editable) VALUES
  ('version', '1.0.0', 'Application version', 0);