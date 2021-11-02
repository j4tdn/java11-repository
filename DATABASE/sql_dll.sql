insert into LoaiHang(MaLH,TenLH)
values(1,"Áo"), (2,"Quần");

insert into LoaiHang(MaLH,TenLH)
values(3,"Mũ");

-- select * from LoaiHang;

insert into MatHang(MaMH,TenMH,MauSac,MaLH)
values (1,"Áo sơ mi nam","Trắng",1),
		(2,"Áo sơ mi nữ","Đen",1);
     

-- disable all foreign keys check
set FOREIGN_KEY_CHECKS=0;

insert into MatHang (MaMH,TenMH,MauSac,MaLH) 
values (3,"Mũ redHat","Đỏ",3),
		(4,"Mũ WhiteHat","Trắng",3);
  
-- enable all foreign keys check
set FOREIGN_KEY_CHECKS=1;

-- safe mode
-- execution plan
delete from MatHang
where MaMH=3;

-- rollback;

-- select * from MatHang;
        
