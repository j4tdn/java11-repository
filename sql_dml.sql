INSERT INTO LoaiHang(MaLH, TenLH)
Values(1,"Ao"),
      (2,"Quan");


insert into MatHang(MaMH, TenMH, MauSac, MaLH) 
values (1, "Ao so mi nam","Trang", 1);

-- disable all foreign key check table
SET FOREIGN_KEY_CHECKS = 0;
insert into MatHang(MaMH, TenMH, MauSac, MaLH) 
values (2, "Mu RedHat","Do", 3),
		(3, "Mu RedHat","Do", 3);
        
SET FOREIGN_KEY_CHECKS = 1;

Delete from MatHang;
ROLLBACK;
COMMIT;

select MaMH,
		TenMH,
        MauSac,
        concat(TenMH,"-", MauSac) Chitiet,
        current_timestamp() ThoiGian
from  mathang;       

select *, if(GiaBan - GiaMua >=30, GiaBan - 15, GiaBan) GiaGiam
from  chitietmathang;  

select COUNT(maMH) from mathang;

select MaMH
From mathang
where maLH = 2
union all
select MaMH 
from chitietdonhang ;

-- phep ket -join
select * from mathang;
select * from loaihang;

-- Liet ke tất cả các mat hang thuoc loai hang la áo
select * 
from mathang
where MaLH = (select MaLH from loaihang where TenLH like '%Áo%');

select *
from mathang mh
join loaihang lh
on mh.MaLH = lh.MaLH
where lh.TenLH like "%Áo";
 
NO OPTION(default), RESTRICT

  