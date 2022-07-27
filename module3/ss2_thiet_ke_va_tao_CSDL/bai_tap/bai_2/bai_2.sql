create database quanlybanhang;
use quanlybanhang;
create table Customer(
cID int primary key,
cName varchar(20) not null,
cAge varchar(20)
);
create table `Order`(
oID int primary key,
cID int,
oDate datetime,
oTotalPrice varchar(20),
foreign key(cID) references Customer(cID)
);
create table Product(
pID int primary key,
pName varchar(20) not null,
pPrice varchar(20)
);
create table OrderDetail(
oID int,
pID int,
odQTY varchar(2),
foreign key(oID) references `Order`(oID),
foreign key(pID) references Product(pID)
);
