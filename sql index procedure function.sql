-- Procedure
-- when: cannot use available DML, DDL to query
-- Liet ke tất cả mặt hàng
--  select * from mathang;
DELIMITER $$
CREATE PROCEDURE selectItem()
BEGIN
    -- code
    SELECT * FROM mathang;
END $$
DELIMITER ;
call selectItem();

DELIMITER $$
CREATE PROCEDURE selectItemByGroupId(p_id int)
BEGIN
    SELECT * FROM mathang where MaLH = p_id;
END $$
DELIMITER ;
call selectItemByGroupId(2);


-- thêm n dòng dữ liệu cho bảng loại hàng
DELIMITER $$
CREATE PROCEDURE addItemGroups(n int)
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE cur_id INT DEFAULT (SELECT max(MaLH) FROM loaihang);
    
	WHILE i <= n DO
		INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (cur_id + i, concat('LH',cur_id+i));
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;
select * from loaihang;
call addItemGroups(5);

SET Global log_bin_trust_function_creators = 1;

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
select sumOf(10);