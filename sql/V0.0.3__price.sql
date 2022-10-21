CREATE TABLE IF NOT EXISTS price_book (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(63) NOT NULL,
  description VARCHAR(127) NULL,
  active BOOLEAN NOT NULL DEFAULT TRUE,
  create_by BIGINT UNSIGNED NOT NULL,
  update_by BIGINT UNSIGNED NOT NULL,
  update_time DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS product_price (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_id BIGINT UNSIGNED NOT NULL,
  price_id BIGINT UNSIGNED NOT NULL,
  list_price DECIMAL(10, 2),
  update_time DATETIME NOT NULL
);
