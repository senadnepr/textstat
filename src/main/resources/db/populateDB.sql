DELETE FROM text_file;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO text_file (name, full_name, number_of_string, average_number, max_word, min_word) VALUES
('text1.txt', 'c:/text/text1.txt', 20, 12, 8, 1),
('text2.txt', 'c:/text/text2.txt', 34, 11, 10, 2),
('text3.txt', 'c:/text/text3.txt', 44, 15, 11, 3)


