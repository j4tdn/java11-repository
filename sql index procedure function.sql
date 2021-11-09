SELECT * FROM MatHang;
-- InDEX FOR MauSac column

SELECT * FROM MAtHang WHERE MauSac = 'Xanh';
EXPLAIN SELECT * FROM MatHang WHERE MauSac = 'Xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON MatHang(MauSac);

-- BEST PRACTICE
-- AUTO
-- 1. PRIMARY KEY - FILTER
-- 2. FOREIGN KEY - JOIN
-- MANUAL
-- 3. PERFOMANCE issue with search or filter frequent column in where clause >> INDEX

-- PROCEDURE
-- Liet Ke tat ca mat hang
-- SELECT * FROM MatHang
DROP PROCEDURE IF EXISTS selectItems;
DELIMITER $$

CREATE PROCEDURE selectItems()
BEGIN
	-- code 
    SELECT * FROM MatHang;
END $$

DELIMITER ;

CALL selectItems();

DELIMITER $$
DROP PROCEDURE IF EXISTS selectItemsByGroupID;
CREATE PROCEDURE selectItemsByGroupID(p_id INT)
BEGIN
	SELECT * FROM MatHang
    WHERE MaLH = p_id;
END $$
DELIMITER ;
CALL selectItemsByGroupID(2);

DELIMITER $$

CREATE PROCEDURE addItemGroup(n INT)
BEGIN
DECLARE i INT DEFAULT 1;
	DECLARE current_igid INT DEFAULT (SELECT MAX(LoaiHang.MaLH) FROM LoaiHang);
	
    WHILE i <= n DO
		INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (current_igid + i, concat('LH',current_igid + i));
		SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;
CALL addItemGroup(6);
SELECT * FROM LoaiHang;

SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION sumOf(n INT)
RETURNS int
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE sumOf INT DEFAULT 0;
	
    WHILE i <= n DO
		SET sumOf = sumOf + i;
        SET i = i + 1;
	END WHILE;
    
    RETURN sumOf;
END $$
DELIMITER ;

SELECT sumOf(2);
