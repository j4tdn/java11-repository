Select * from mathang where MauSac = "Xanh";
Explain Select * from mathang where MauSac = "Xanh";
-- Auto B-INDEX
create index IDX_COLOR
ON MatHang(MauSac);

-- Best Practice 
-- AUTO
-- 1. Primary key - Filter
-- 2. FOREIGN KEY - JOIN
-- MANUAL
-- 3. Performance issue with searching or fillter frequence column in where clause  >> INDEX
