DROP TABLE IF EXISTS cars;

CREATE TABLE cars (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  make_name VARCHAR(250) NOT NULL,
  model_name VARCHAR(250) NOT NULL,
  horsepower INTEGER NOT NULL,
  retail_price INTEGER NOT NULL
);

INSERT INTO cars (make_name, model_name, horsepower, retail_price) VALUES
  ('Nissan', 'GTR', 530, 101000),
  ('Ferrari', 'F430', 490, 186925),
  ('Nissan', '400Z', 401, 48000);