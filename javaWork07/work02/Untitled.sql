//关闭自动提交，一次性插入100万数据，用时3分钟左右
DROP PROCEDURE IF EXISTS insert_order_close_ac;
CREATE PROCEDURE insert_order_close_ac()
BEGIN
	DECLARE i INT DEFAULT 1;
	SET autocommit = 0;
	WHILE i<=1000000 DO
		INSERT INTO `order` (`price`, `status`, `userId`, `productId`)
		VALUES (2.5, 0, RAND()%10000, RAND()%10);
		SET i = i+1;
	END WHILE;
	COMMIT;
END;

CALL insert_order_close_ac();

//打开自动提交（默认），插入速度很慢
DROP PROCEDURE IF EXISTS insert_order_open_ac;
CREATE PROCEDURE insert_order_open_ac()
BEGIN
	DECLARE i INT DEFAULT 1;
	WHILE i<=1000000 DO
		INSERT INTO `order` (`price`, `status`, `userId`, `productId`)
		VALUES (2.5, 0, RAND()%10000, RAND()%10);
		SET i = i+1;
	END WHILE;
END;

CALL insert_order_open_ac();
