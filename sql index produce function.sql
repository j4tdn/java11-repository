
SELECT * FROM MatHang WHERE MauSac = "Xanh";
EXPLAIN SELECT * FROM MatHang WHERE MauSac = "Xanh";


-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON MATHANG(MauSac);


-- BEST PRACTICE
-- 1. PRIMARY KEY - FILTER
-- 2. FOREIGN KEY - JOIN
-- MANUAL
-- 3. PERFORMANCE ISSUE WITH SEARCH OR FILTER FREQUENT COLUMN IN WHERE CLAUSE >> INDEX  

-- PRODUCE - FUNCTION
-- WHEN : Cannot use available DML, DDL to query

-- Liệt kê tất cả mặt hàng
-- SELECT * FROM MatHang

DELIMITER $$
CREATE PROCEDURE selectItems()
BEGIN
	-- code 
    SELECT * FROM MatHang;
END $$
DELIMITER ;

CALL selectItems();

-- Liệt kê các mặt hàng theo loại hàng
DROP PROCEDURE IF EXISTS selectItemByGroup;
DELIMITER $$
CREATE PROCEDURE selectItemsByGroup(p_id int)
BEGIN
	-- code 
    SELECT * FROM MatHang
    WHERE MaLH = p_id;
END $$
DELIMITER ;

CALL selectItemsByGroup(2);

-- Thêm N dòng dữ liệu cho loại mặt hàng
-- VD : N = 5
-- MaLH TenLH
-- 1 	Áo
-- 2	Quần
-- 6	Mũ
-- --------- 
-- 7	LH7
-- 8	LH8

DELIMITER $$
CREATE PROCEDURE addItemGroups(n int)
BEGIN
	-- code
    DECLARE i INT DEFAULT 1;
	DECLARE current_igid INT DEFAULT (SELECT MAX(loaihang.MaLH) + 1 FROM loaihang);
    
    WHILE i <= n DO
		SET current_igid = current_igid + 1;
		INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (current_igid  + 1, concat('LH', current_igid));
        SET  i = i + 1;
     
    END WHILE;
END $$
DELIMITER ;

CALL addItemGroups(5);
SELECT * FROM LoaiHang;