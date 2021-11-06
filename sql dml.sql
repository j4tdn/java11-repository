COMMIT;
ROLLBACK;

INSERT INTO LOAIHANG(MALH, TENLOAI)
VALUES (1, "Áo"),
       (2, "Quần");

INSERT INTO LOAIHANG(MALH, TENLOAI)
VALUES (3, "Mũ");

INSERT INTO MATHANG(MAMH, TENMH, MAUSAC, MALH)
VALUES (1, "Áo sơ mi nam", "Trắng", 1),
       (2, "Áo sơ mi nữ", "Đen", 1);

-- disable all foreign keys check
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO MATHANG(MAMH, TENMH, MAUSAC, MALH)
VALUES (3, "Mũ RedHat", "Đỏ", 3),
       (4, "Mũ WhiteHat", "Trắng", 3);
-- enable all foreign keys check
SET FOREIGN_KEY_CHECKS = 1;

-- safe mode
-- sql: execution plan
DELETE
FROM MATHANG
WHERE MAMH = 4;

DELETE
FROM LOAIHANG
WHERE MALH = 3;

ROLLBACK;

SELECT *
FROM MATHANG;

-- Cập nhật màu sắc của tất cả các mặt hàng có loại hàng = 2 thành màu xanh
UPDATE MATHANG
SET MAUSAC = 'Xanh'
WHERE MALH = 2;

-- MERGE - saveOrUpdate
-- INSERT - UPDATE

-- saveOrUpdate(new Item(2, 'Áo sơ mi', 'Trắng', 1))

-- JDBC executeQuery, executeUpdate
-- update >> INSERT, UPDATE, DELETE
-- select >> SELECT

SELECT *
FROM MATHANG;

-- concatenate(... strings)
SELECT MAMH,
       TENMH,
       MAUSAC,
       CONCAT(TENMH, '-', MAUSAC) CHITIET,
       CURRENT_TIMESTAMP()        THOIGIAN
FROM MATHANG
LIMIT 1,5;

-- group_concat(column)
SELECT GROUP_CONCAT(TENMH SEPARATOR '-'),
       MALH
FROM MATHANG
GROUP BY MALH;

-- Giảm 15k nếu giá bán lớn hơn giá mua 30k trở lên
SELECT *,
       IF(GIABAN - GIAMUA >= 30, GIABAN - 15, GIAMUA) GIAGIAM
FROM CHITIETMATHANG
ORDER BY MAKC DESC;
-- default ASC

-- group by
SELECT *
FROM MATHANG;

-- function count, sum, avg, min, max
-- count(column) >> return 1 row
SELECT MALH,
       COUNT(*)                           SOLUONGMATHANG,
       GROUP_CONCAT(TENMH SEPARATOR ', ') MATHANG
FROM MATHANG
WHERE MALH IN (1, 3, 5)
GROUP BY MALH
HAVING SOLUONGMATHANG >= 2
ORDER BY MALH DESC;

-- 3,4,5
SELECT MAMH
FROM MATHANG
WHERE MALH = 2
UNION
-- 1,1,2,3,4,6,8
SELECT MAMH
FROM CHITIETDONHANG;

-- Phép kết - JOIN
SELECT *
FROM MATHANG;
SELECT *
FROM LOAIHANG;
INSERT INTO LOAIHANG(MALH, TENLH)
VALUES (6, 'Tất');

-- Liệt kê tất cả cac mặt hàng thuộc loại hàng là Áo
SELECT *
FROM MATHANG
WHERE MALH = (SELECT MALH FROM LOAIHANG WHERE TENLH LIKE '%Áo%');

SELECT MH.*,
       LH.TENLH
FROM MATHANG MH
JOIN LOAIHANG LH
ON LH.MALH = MH.MALH
WHERE LH.TENLH LIKE '%Áo%';

SELECT MH.*,
       LH.TENLH
FROM MATHANG MH
RIGHT JOIN LOAIHANG LH
ON LH.MALH = MH.MALH

