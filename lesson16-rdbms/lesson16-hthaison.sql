SELECT * FROM mathang WHERE MauSac = 'Xanh';
EXPLAIN SELECT * FROM mathang WHERE MauSac = 'Xanh';

CREATE INDEX IDX_COLOR
ON mathang(MauSac);

-- PROCEDURE - FUNCION
-- WHEN: cannot use availiable DML. DDL to query

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

-- them n dong du lieu cho bang loai hang
DELIMITER $$
CREATE PROCEDURE addItemGroups(n int)
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE current_igid INT DEFAULT (SELECT MAX(MaLH) FROM loaihang);
    
	WHILE i <= n DO
		INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (current_igid + i, concat('LH' , current_igid + i));
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;

CALL addItemGroups(5);
SELECT * from loaihang;

SET GlOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION sumOf(n int)
RETURNS INT
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