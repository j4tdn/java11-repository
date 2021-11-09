insert into LoaiHang(MaLH, TenLoai)
values(1,"Ao"),
	  (2,"Quan");
      
insert into LoaiHang(MaLH, TenLoai)
values(3,"Mu");

insert into MatHang(MaMH, TenMH, MauSac, MaLH)
values(1,"Ao so mi nam", "trang",1),
		(2, "ao so mi nu", "den",1);
-- diasble all foreign keys check 
set FOREIGN_KEY_CHECKS = 0;
insert into MatHang(MaMH, TenMH, MauSac, MaLH)
values(3,"Mu redhat", "trang",3),
		(4, "Mu white", "den",3);
set FOREIGN_KEY_CHECKS = 1;
-- safe mode
DELETE FROM MatHang
where MaMH = 4;

delete from LoaiHang
where MaLH = 3;

rollback;

SELECT *
FROM MatHang;

SELECT MaMH,
	   TenMH,
       MauSac,
       concat(TenMH,'-', MauSac) AS ChiTiet,
       current_timestamp() ThoiGian
FROM MatHang;

SELECT
		MaMH,
        TenMH,
        MauSac,
        concat(TenMH,'-', MauSac) AS ChiTiet,
        current_timestamp() ThoiGian
FROM MatHang
LIMIT 1, 5;

SELECT *, if(GiaBan - GiaMua >= 30, GiaBan-15, GiaBan) AS GiaGiam
FROM ChiTietMatHang
ORDER BY MaKC DESC, GiaBan ASC; -- default ASC

-- function count, avg, max, min, sum
-- count(column) >> return 1 row
SELECT 
	MaLH,
    COUNT(*) SoLuongMatHang,
    GROUP_CONCAT(TenMH SEPARATOR '-') MatHang
FROM MatHang
WHERE MaLH IN (1,3,5)
GROUP BY MaLH
HAVING SoLuongMatHang >= 2
ORDER BY MaMH DESC;

SELECT GROUP_CONCAT(TenMH SEPARATOR '-'),
		MaLH
FROM MatHang;

UPDATE MatHang
SET MauSac = NULL
WHERE MaMH IN(2,5,7);

SELECT MaMH
FROM MatHang
WHERE 


