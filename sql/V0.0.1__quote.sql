CREATE TABLE IF NOT EXISTS quote (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(63) NOT NULL,
  opportunity_id BIGINT UNSIGNED NULL,
  expiration_time DATETIME NULL,
  status ENUM('DRAFT', 'NEEDS_REVIEW', 'IN_REVIEW', 'APPROVED', 'REJECTED', 'PRESENTED', 'ACCEPTED', 'DENIED') NOT NULL,
  description VARCHAR(127) NULL,
  subtotal DECIMAL(10, 2) COMMENT 'sum of the subtotal of all items',
  total_price DECIMAL(10, 2) COMMENT 'sum of the total price of all items',
  create_by BIGINT UNSIGNED NOT NULL,
  update_by BIGINT UNSIGNED NOT NULL,
  update_time DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS quote_line_item (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_id BIGINT UNSIGNED NOT NULL,
  sales_price DECIMAL(10, 2),
  quantity DECIMAL(10, 2),
  subtotal DECIMAL(10, 2) COMMENT 'sales price * quantity',
  discount DECIMAL(4, 4),
  total_price DECIMAL(10, 2) COMMENT 'subtotal - subtotal * discount',
  update_time DATETIME NOT NULL
);
