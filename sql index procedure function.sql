
-- EXECUTION PLAN

--
SELECT * FROM mathang;

--  INDEX FOR MauSac column
SELECT * FROM MatHang WHERE MauSac = 'Xanh';
EXPLAIN SELECT * FROM MatHang WHERE MauSac = 'Xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON MatHang(MauSac);

-- BEST PRACTICE
-- AUTO
-- 1. PRIMARY KEY - FILTER
-- 2. FOREIGN KEY - JOIN
-- MANUAL
-- 3. Performence issue with searching or filter frequent colum in where clause >> INDEX

-- PROCEDURE - FUNCTION
-- WHEN: Cannot use available DML, DDL to query
-- Liệt kê tất cả mặt hàng
-- SELECT * FROM MatHang

DELIMITER $$
CREATE PROCEDURE selectItems()
BEGIN
    SELECT * FROM MatHang;
END $$
DELIMITER ;

CALL SelectItems();

DROP PROCEDURE IF EXISTS selectItemsByGroupId;

DELIMITER $$
CREATE PROCEDURE selectItemsByGroupId(p_id int)
BEGIN
    SELECT * FROM MatHang
    WHERE MaLH = p_id;
END $$
DELIMITER ;

CALL selectItemsByGroupId(2);

DROP PROCEDURE IF EXISTS selectItemsByGroupId;
DELIMITER $$
CREATE PROCEDURE addItemGroups(n int)
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE current_igid INT DEFAULT (SELECT MAX(MaLH) FROM LoaiHang);
	WHILE i <= n DO
		INSERT INTO LoaiHang(MaLH, TenLH) 
        VALUES (current_igid + i, concat('LH', current_igid + i));
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;

CALL addItemGroups(5);

SELECT * FROM loaihang;
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION sumOf(N int)
RETURNS int
BEGIN
	DECLARE i INT DEFAULT 1;
    DECLARE sumOf INT DEFAULT 0;
    
    WHILE i <= N DO
		SET sumOf = sumOf + i;
        SET i = i + 1;
	END WHILE;
    RETURN sumOf;
END $$
DELIMITER ;

SELECT sumOf(10);