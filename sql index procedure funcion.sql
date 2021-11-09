SELECT * FROM mathang WHERE MauSac = 'Xanh';
EXPLAIN SELECT * FROM mathang WHERE MauSac = 'Xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON mathang(MauSac);

-- BEST FRACTICE
-- AUTO
-- 1. PRIMARY KEY - FILTER
-- 2. FOREIGN KEY  - JOIN 
-- MANUAL
-- 3. Performance issue with searching or filter frequent column

DELIMITER $$
CREATE PROCEDURE selectItems()
BEGIN
-- code
SELECT * FROM mathang;
END $$
DELIMITER ;
CALL selectItems();

-- liet ke cac mat hang theo loai hang
DROP PROCEDURE IF EXISTS selectItemsByGroupId;
DELIMITER $$
CREATE PROCEDURE selectItemsByGroupId(p_id int)
BEGIN
-- code
SELECT * FROM mathang WHERE MaLH = p_id;
END $$
DELIMITER ;

CALL selectItemsByGroupId(2);

-- Thêm N dòng dữ liệu cho bảng loại hàng
-- VD: N = 5
-- MaLH TenLH
--   1    Áo
--   2   Quần
--   6    Mũ
-- ------------
--   7    LH7
--   8    LH8
--   9    LH9
--   10   LH10
--   11   LH1

DELIMITER $$
CREATE PROCEDURE addItemGroups(n int)
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE current_igid INT DEFAULT (SELECT MAX(MaLH) FROM loaihang);
    
	WHILE i <= n DO
		INSERT INTO LoaiHang(MaLH, TenLH) 
        VALUES (current_igid + i, concat('LH', current_igid + i));
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;

CALL addItemGroups(5);

SELECT * FROM loaihang;