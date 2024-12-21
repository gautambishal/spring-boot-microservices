----adding shop operators, queue , customer
CREATE TABLE shop_operator (
                               id SERIAL PRIMARY KEY,
                               username VARCHAR(255) NOT NULL UNIQUE,
                               password VARCHAR(255) NOT NULL,
                               shop_id uuid NOT NULL,
                               CONSTRAINT fk_shop_operator_shop FOREIGN KEY (shop_id) REFERENCES shop (id) ON DELETE CASCADE
);

CREATE TABLE queue (
                       id SERIAL PRIMARY KEY,
                       shop_id uuid NOT NULL,
                       queue_size INT DEFAULT 0,
                       served_count INT DEFAULT 0,
                       CONSTRAINT fk_queue_shop FOREIGN KEY (shop_id) REFERENCES shop (id) ON DELETE CASCADE
);

-- Create Customer Table
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          queue_id INT NOT NULL,
                          served_count INT DEFAULT 0,
                          CONSTRAINT fk_customer_queue FOREIGN KEY (queue_id) REFERENCES queue (id) ON DELETE CASCADE
);

-- Create Order Table
CREATE TABLE order_table (
                             id SERIAL PRIMARY KEY,
                             customer_id INT NOT NULL,
                             order_details TEXT NOT NULL,
                             CONSTRAINT fk_order_customer FOREIGN KEY (customer_id) REFERENCES customer (id) ON DELETE CASCADE
);