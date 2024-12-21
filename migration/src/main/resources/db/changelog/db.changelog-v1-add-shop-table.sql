-- BaseEntity: Fields to be inherited
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create Shop table
CREATE TABLE shop (
                      id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                      shop_name VARCHAR(255) NOT NULL,
                      location VARCHAR(255) NOT NULL,
                      contact_details VARCHAR(255) NOT NULL,
                      number_of_queues INT NOT NULL,
                      max_queue_size INT NOT NULL,
                      opening_time TIME NOT NULL,
                      closing_time TIME NOT NULL,
                      creation_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                      update_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- Create MenuItem table
CREATE TABLE menu_items (
                            id BIGSERIAL PRIMARY KEY,
                            item_name VARCHAR(255) NOT NULL,
                            price DECIMAL(10, 2) NOT NULL,
                            shop_id UUID NOT NULL,
                            CONSTRAINT fk_menu_items_shop FOREIGN KEY (shop_id) REFERENCES shop (id) ON DELETE CASCADE
);
