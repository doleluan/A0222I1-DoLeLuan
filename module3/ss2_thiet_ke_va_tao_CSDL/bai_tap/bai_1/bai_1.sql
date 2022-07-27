use quanlyhang;
create table PHIEUXUAT(
SoPX int primary key,
NgayXuat datetime  not null
);
create table VATTU(
MaVTU varchar(20) primary key,
TenVTU varchar(20) not null
);
create table PHIEUNHAP(
SoPN varchar (20) primary key,
NgayNhap datetime
);
create table DONDH(
SoDH varchar(20) primary key,
NgayDH datetime,
MaNCC varchar(20),
foreign key (MaNCC) references NHACC(MaNCC)
);
create table NHACC(
MaNCC varchar(20) primary key,
TenNCC varchar(20),
DiaChi varchar(20)
);
create table THONGTIN(
SDT varchar(11),
MaNCC varchar(20),
foreign key (MaNCC) references NHACC(MaNCC)
);
create table CHITIETPHIEUXUAT(
DGXUAT varchar(20) not null,
SLXUAT int not null,
SoPX int,
MaVTU varchar(20),
foreign key(SoPX) references PHIEUXUAT(SoPX),
foreign key(MaVTU) references VATTU(MaVTU)
);
create table CHITIETPHIEUNHAP(
DGNHAP varchar(20) not null,
SLNHAP int not null,
SoPN varchar (20),
MaVTU varchar(20),
foreign key(SoPN) references PHIEUNHAP(SoPN),
foreign key(MaVTU) references VATTU(MaVTU)
);
create table CHITIETDONDATHANG(
MaVTU varchar(20),
SoDH varchar(20),
foreign key(MaVTU) references VATTU(MaVTU),
foreign key(SoDH) references DONDH(SoDH)
);
