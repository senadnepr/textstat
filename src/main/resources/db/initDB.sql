DROP TABLE IF EXISTS text_file;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE text_file
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  full_name        VARCHAR                 NOT NULL,
  number_of_string INTEGER                 NOT NULL,
  average_number   INTEGER                 NOT NULL,
  max_word         INTEGER                 NOT NULL,
  min_word         INTEGER                 NOT NULL
);
CREATE UNIQUE INDEX text_file_unique_full_name_idx ON text_file (full_name);

DELETE FROM text_file;

