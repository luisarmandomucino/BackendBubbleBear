USE bbdatabase;

SELECT * FROM bbdatabase.orders_has_products;


INSERT INTO orders_has_products (quantity, fk_order_id, fk_product_id, price_product)
	VALUES ( 3, 2, 2, 80);

INSERT INTO orders_has_products (quantity, fk_order_id, fk_product_id, price_product)
	VALUES ( 6, 3, 5, 50);

INSERT INTO orders_has_products (quantity, fk_order_id, fk_product_id, price_product)
	VALUES ( 1, 4, 4, 120);
    
INSERT INTO orders_has_products (quantity, fk_order_id, fk_product_id, price_product)
	VALUES ( 30,5, 2, 80);
    
INSERT INTO orders_has_products (quantity, fk_order_id, fk_product_id, price_product)
VALUES ( 10, 2, 4, 120);