-- SELECT ALL ITEMS
DELIMITER $$
CREATE PROCEDURE selectItems()
BEGIN
	SELECT * FROM MatHang;
END $$
DELIMITER ;
-- SELECT BY CATEGORY
DELIMITER $$
CREATE PROCEDURE selectItemByGroupId(p_id int)
BEGIN
	SELECT * FROM MatHang WHERE MaLH = p_id;
END $$
DELIMITER ;

-- INSERT N LINE
DELIMITER $$
CREATE PROCEDURE insertItem(n int)
BEGIN
    DECLARE i INT DEFAULT 1;
	DECLARE current_igid int DEFAULT (SELECT max(MaMH)  FROM MatHang);
    WHILE i <= n DO
        INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (current_igid + i, concat('LH', i));
        SET i = i +1;
	END WHILE;
END $$
DELIMITER ;

CALL  insertItem(3);

select * from LoaiHang;

-- HOMEWORK 

SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION sumOf(n int)
RETURNS int
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE sumOf INT DEFAULT 0;
    WHILE i < 10 DO
		SET sumOf = sumOf + i;
        SET i = i + 1;
    END WHILE;
    RETURN sumOf;
END $$
DELIMITER ;

select sumOf(5);


