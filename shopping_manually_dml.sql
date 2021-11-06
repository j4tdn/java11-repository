insert into loaihang
values (1, "Áo"), (2, "Quần");

insert into MatHang
values (1, "Sơ Mi Nam", "trắng", 1),
	   (2, "dài", "Đen", 2);
       
set Foreign_Key_checks = 0;

select * from mathang;

select group_concat(TenMH separator '-')
	MaLH
    from mathang
    group by

