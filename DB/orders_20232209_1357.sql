USE bbdatabase;
SELECT * FROM bbdatabase.orders;


INSERT 
INTO orders (purchase_date, total_amount, fk_user_id)
	VALUES ("2023-09-15", 500, 2);
INSERT 
INTO orders (purchase_date, total_amount, fk_user_id)
	VALUES ("2023-12-14", 250, 1);
INSERT 
INTO orders (purchase_date, total_amount, fk_user_id)
	VALUES ("2022-04-16", 80, 3);
INSERT 
INTO orders (purchase_date, total_amount, fk_user_id)
	VALUES ("2021-01-25", 50, 4);
INSERT 
INTO orders (purchase_date, total_amount, fk_user_id)
	VALUES ("2023-07-13", 6000, 2);SELECT * FROM bbdatabase.orders;