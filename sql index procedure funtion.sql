-- INDEX FOR MauSac column

SELECT * FROM mathang WHERE MauSac = 'Xanh';
EXPLAIN SELECT * FROM mathang WHERE MauSac = 'Xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON mathang(MauSac);

-- BEST PRACTICE
    -- AUTO
        -- 1. PRIMARY KEY
        -- 2. FOREIGN KEY - JOIN
    -- MANUAL
        -- 3. Performance issue with searching or filter frequent column in where clause >> INDEX
        
-- PROCEDURE - FUNCTION
-- WHEN: Cannot use available DML, DDL to query

-- Liệt kê tất cả mặt hàng
-- SELECT * FROM mathang

DROP PROCEDURE IF EXISTS selectItems;
DELIMITER $$
CREATE PROCEDURE selectItems()
BEGIN
    -- code
    SELECT * FROM mathang;
END $$
DELIMITER ;

CALL selectItems();

DROP PROCEDURE IF EXISTS selectItemsByGroupId;
DELIMITER $$
CREATE PROCEDURE selectItemsByGroupId(p_id int)
BEGIN
    -- code
    SELECT * FROM mathang WHERE MaLH = p_id;
END $$
DELIMITER ;

CALL selectItemsByGroupId(2);

-- Thêm N  dòng dữ liệu cho từng loại hàng
-- VD: N = 5
-- MaLH TenLH
--  1    Áo
--  2    Quần
--  6    Mũ
-- ---------
-- 7     LH7
-- 8     LH8
-- 9     LH9
-- 10    LH10
-- 11    LH11

DROP PROCEDURE IF EXISTS addItemGroups;
DELIMITER $$
CREATE PROCEDURE addItemGroups(n int)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE current_igid INT DEFAULT (SELECT MAX(MaLH) FROM loaihang); -- 6
	
    WHILE i <= n DO
        INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (current_igid + 1, concat('LH', current_igid + 1));
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS addItemGroups;
CALL addItemGroups(5);
SELECT * FROM loaihang;


SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION sumOf(n int)
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

SELECT sumOf(10);