EXPLAIN SELECT * FROM java11_shopping.mathang where MauSac = 'Xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
ON mathang(MauSac);

-- PROCEDURE
-- Liệt kê các mặt hàng
DELIMITER $$
CREATE PROCEDURE getItems()
BEGIN
	SELECT * FROM MatHang;
END $$
DELIMITER ;

CALL getItems();
-- Liệt kê các mặt hàng theo loại hàng
DELIMITER $$
CREATE PROCEDURE getItemsByGroupId(p_id int)
BEGIN
	SELECT * FROM MatHang
	WHERE MaLH = p_id;
END $$
DELIMITER ;

CALL getItemsByGroupId(1);
-- Thêm N dòng dữ liệu cho bảng loại hàng 
DELIMITER $$
CREATE PROCEDURE addToLoaiHang(n int)
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

CALL addToLoaiHang(3);

-- Liệt kê các phần tử chẵn nhỏ hơn N
DELIMITER $$
CREATE PROCEDURE selectItemsEvenLessThan(n int)
BEGIN
	
END $$
DELIMITER ;

-- FUNCTION
-- Tổng phần tử chẵn nhỏ hơn N 
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION sumOf(n int)
RETURNS int
BEGIN
	DECLARE i INT DEFAULT 1;
    DECLARE sumOf INT DEFAULT 0;
    
    WHILE i <= n DO
		IF i % 2 = 0 THEN
			SET sumOf = sumOf + i;
		END IF;
        SET i = i + 1;
	END WHILE;
    
    RETURN sumOf;
END $$
DELIMITER ;

SELECT sumOf(10);