CREATE TABLE IF NOT EXISTS product (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(63) NOT NULL,
  code VARCHAR(31) NULL,
  description VARCHAR(127) NULL,
  active BOOLEAN NOT NULL DEFAULT TRUE,
  update_time DATETIME NOT NULL
);
