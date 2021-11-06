-- 1. CREATE new database
CREATE SCHEMA java11_shopping_manually CHAR SET utf8mb4;
USE java11_shopping_manually;
-- 2. create new table
-- 3. constraint pk, fk
CREATE TABLE LoaiHang(
	MaLH INT,
    TenLoai VARCHAR(255) NOT NULL,
    CONSTRAINT PK_LoaiHang PRIMARY KEY (MaLH)
);
CREATE TABLE MatHang(
	MaMH INT,
    TenMH VARCHAR(255) NOT NULL,
    MauSac VARCHAR(255) NOT NULL,
    MaLH INT NOT NULL,
    PRIMARY KEY (MaMH),
    PRIMARY KEY (MaMH),
    CONSTRAINT FK_MatHang_LoaiHang FOREIGN KEY (MaLH) REFERENCES LoaiHang(MaLH)
);
ALTER TABLE MatHang
ADD CONSTRAINT PK_MatHang PRIMARY KEY (MaMH);
-- 4. add one table 
ALTER TABLE LoaiHang
ADD NgayTao DATE NOT NULL DEFAULT (curdate());
-- 5. change name column
ALTER TABLE LoaiHang
CHANGE NgayTao Created DATE NOT NULL DEFAULT(curdate());
-- 6. create new table
CREATE TABLE KichCo(
	MaKC VARCHAR(10),
    MoTa VARCHAR(255) NOT NULL,
    CONSTRAINT PK_KichCo PRIMARY KEY (MaKc)
);
-- 7. create new table
-- 8. constraint pk fk
CREATE TABLE ChiTietMatHang(
	MaMH INT,
    MaKC VARCHAR(10),
    HinhAnh VARCHAR(255) NOT NULL,
    GiaBan DOUBLE NOT NULL,
    GiaMua DOUBLE NOT NULL,
    SoLuong INT NOT NULL,
    CONSTRAINT PK_ChiTietMatHang PRIMARY KEY (MaMH, MaKC),
    CONSTRAINT FK_ChiTietMatHang_MatHang FOREIGN KEY (MaMH) REFERENCES MatHang(MaMH),
    CONSTRAINT FK_ChiTietMatHang_KichCo FOREIGN KEY (MaKC) REFERENCES KichCo(MaKC)
);
-- 9. delete column 
ALTER TABLE LoaiHang
DROP COLUMN NgayTao; 
-- 10. truncate table
-- 11. show all table 
SELECT * FROM information_schema.tables
WHERE TABLE_SCHEMA = 'java11_shopping_manually';