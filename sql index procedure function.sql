SELECT * FROM MatHang WHERE MauSac = 'Xanh';
EXPLAIN SELECT * FROM MatHang WHERE MauSac = 'Xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON MatHang(MauSac);

-- PROCEDURE 
-- WHEN: Cannot use available DML, DDL to query

-- Liệt kê tất cả các mặt hàng 
-- SELECT * FROM MatHang

DROP PROCEDURE IF EXISTS selectItems;
DELIMITER $$ 
CREATE PROCEDURE selectItems()
BEGIN
	-- code
    SELECT * FROM MatHang;
END $$
DELIMITER ;

-- Liệt kê các mặt hàng theo loại hàng
DROP PROCEDURE IF EXISTS selectItemsByGroupId;
DELIMITER $$ 
CREATE PROCEDURE selectItemsByGroupId(p_id int)
BEGIN
	-- code
    SELECT * FROM MatHang WHERE MaLH = p_id;
END $$
DELIMITER ;

-- Thêm N dòng dữ liệu cho bảng loại hàng
-- VD: N = 5
-- MaLH TenLH
--  1    Áo
--  2    Quần
--  6    Mũ
-- ----------
--  7    LH7
--  8    LH8
-- ----------

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

CALL selectItems();
CALL selectItemsByGroupId(2);
CALL addItemGroups(5);

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

SELECT sumOf(10)