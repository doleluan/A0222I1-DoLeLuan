-- use quanlydiemthi;
create table HocSinh(
MaHs varchar(20) primary key unique,
TenHs varchar(50),
NgaySinh date,
Lop varchar(20),
GT varchar(20)
);
create table  MonHoc(
MaMh varchar(20) primary key unique,
TenMh varchar(20),
MaGV varchar(20)
);
create table BangDiem(
	MaHs varchar(20),
    MaMh varchar(20),
    DiemThi float check (DiemThi >0 or DiemThi <10),
    NgayKT date,
    primary key (MaHs,MaMh),
    foreign key (MaHs) references HocSinh(MaHs),
    foreign key (MaMh) references MonHoc(MaMh)
);
create table GiaoVien(
	MaGV varchar(20) primary key unique,
    TenGV varchar(20),
    SDT VARCHAR(10)
);
ALTER TABLE MonHoc ADD CONSTRAINT FK_MaGV FOREIGN KEY (MaGV) REFERENCES GiaoVien(MaGV);