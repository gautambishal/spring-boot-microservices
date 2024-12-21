INSERT INTO shop (id, shop_name, location, contact_details, number_of_queues, max_queue_size, opening_time, closing_time, creation_timestamp, update_timestamp)
VALUES
    ('eafbd320-d4f2-11ec-9d64-0242ac120002', 'Coffee House Downtown', 'Downtown City', '123-456-7890', 2, 10, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('eafbd321-d4f2-11ec-9d64-0242ac120003', 'Coffee Corner', 'Uptown City', '098-765-4321', 1, 5, '08:00:00', '20:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO menu_items (item_name, price, shop_id)
VALUES
    ('Espresso', 3.50, 'eafbd320-d4f2-11ec-9d64-0242ac120002'),
    ('Latte', 4.50, 'eafbd320-d4f2-11ec-9d64-0242ac120002'),
    ('Cappuccino', 4.00, 'eafbd321-d4f2-11ec-9d64-0242ac120003'),
    ('Mocha', 5.00, 'eafbd321-d4f2-11ec-9d64-0242ac120003');

INSERT INTO shop_operator (username, password, shop_id)
VALUES
    ('john_doe', 'password123', 'eafbd320-d4f2-11ec-9d64-0242ac120002'),
    ('jane_smith', 'password456', 'eafbd321-d4f2-11ec-9d64-0242ac120003');
INSERT INTO queue (shop_id, queue_size, served_count)
VALUES
    ('eafbd320-d4f2-11ec-9d64-0242ac120002', 0, 0),
    ('eafbd321-d4f2-11ec-9d64-0242ac120003', 0, 0);
INSERT INTO customer (name, queue_id, served_count)
VALUES
    ('Alice Johnson', (SELECT id FROM queue WHERE shop_id = 'eafbd320-d4f2-11ec-9d64-0242ac120002'), 0),
    ('Bob Brown', (SELECT id FROM queue WHERE shop_id = 'eafbd320-d4f2-11ec-9d64-0242ac120002'), 0),
    ('Charlie Davis', (SELECT id FROM queue WHERE shop_id = 'eafbd321-d4f2-11ec-9d64-0242ac120003'), 0);
INSERT INTO order_table (customer_id, order_details)
VALUES
    ((SELECT id FROM customer WHERE name = 'Alice Johnson'), 'Espresso'),
    ((SELECT id FROM customer WHERE name = 'Bob Brown'), 'Latte'),
    ((SELECT id FROM customer WHERE name = 'Charlie Davis'), 'Cappuccino');
