DROP TABLE IF EXISTS inventory;

CREATE TABLE inventory (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  item_name VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  price_per_unit INT NOT NULL
);

INSERT INTO inventory (item_name, quantity, price_per_unit) VALUES
  ('Ikigai', 12, 350),
  ('Rich dad poor dad',35, 250),
  ('Secret of nagas', 50, 300);