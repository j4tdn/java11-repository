SELECT *
FROM MATHANG
WHERE MAUSAC = 'xanh';

EXPLAIN
SELECT *
FROM MATHANG
WHERE MAUSAC = 'xanh';

-- AUTO B-TREE
CREATE INDEX IDX_COLOR
    ON MATHANG (MAUSAC);

-- BEST PRACTICE
-- AUTO
-- 1. PRIMARY KEY - FILTER
-- 2. FOREIGN KEY - JOIN
-- MANUAL
-- 3. Performance issue with searching or filter frequent column in where clause >> INDEX

-- PROCEDURE
-- WHEN: Cannot use available DML, DDL to query

-- Liệt kê tất cả mặt hàng
-- SELECT * FROM MatHang

DROP PROCEDURE IF EXISTS selectItems;
DELIMITER $$
CREATE PROCEDURE selectItems()
BEGIN
    -- code
    SELECT * FROM MatHang;
END $$;
DELIMITER ;

CREATE PROCEDURE selectItemsByGroupId(p_id INT)
BEGIN
    -- code
    SELECT * FROM MatHang WHERE MaLH = p_id;
END;

CALL selectItems();
CALL selectItemsByGroupId(2);

CREATE PROCEDURE addItemGroups(n INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE current_igid INT DEFAULT (SELECT max(MaLH) FROM LoaiHang);

    WHILE i <= n DO
        INSERT INTO LoaiHang(MaLH, TenLH)
        VALUES (current_igid + i, concat('LH', current_igid + i));
        SET i = i + 1;
    END WHILE;
END;

SELECT *
FROM LoaiHang;
CALL addItemGroups(5);


SET GLOBAL log_bin_trust_function_creators = 1;

CREATE FUNCTION  sumOf(n INT)
RETURNS INT
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE sumOf INT DEFAULT 0;

    WHILE i <= n DO
        SET sumOf = sumOf + i;
        SET i = i + 1;
    END WHILE;

    RETURN sumOf;
END;

SELECT sumOf(10);







