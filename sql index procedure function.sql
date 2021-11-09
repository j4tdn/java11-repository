-- SELECT * FROM mathang

DELIMITER $$

CREATE PROCEDURE selectItem()
BEGIN
	-- code
	SELECT * FROM mathang;
END $$
DELIMITER ;

CALL selectItem();

DELIMITER $$
CREATE PROCEDURE addNewLoaiHangTable(n int)
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE current_igid INT DEFAULT (SELECT MAX(MaLH) FROM loaihang);

	WHILE i < n DO
		INSERT INTO LoaiHang(MaLH, TenLH) 
        VALUES (current_igid + i, concat('LH', current_igid + i));
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;

SELECT * FROM loaihang;

CALL addNewLoaiHangTable(5);