use quanlybanhang;
create database quanlybanhang;
create table Customer(
cID int primary key auto_increment,
cName varchar(20) not null,
cAge int 
);
create table `Order`(
oID int primary key auto_increment,
cID int,
oDate date,
oTotalPrice varchar(20),
foreign key(cID) references Customer(cID)
);
create table Product(
pID int primary key auto_increment,
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
insert into Customer(cName,cAge)
values ('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);
insert into `Order`(cID,oDate,oTotalPrice)
values (1,'2006-3-21',null),
(2,'2006-3-23',null),
(1,'2006-3-16',null);
insert into Product(pName,pPrice)
values ('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);
insert into OrderDetail(oID,pID,odQTY)
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select 	oID,oDate,oTotalPrice 
from `Order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.cName,p.pName
from Customer c join `Order` o on c.cID = o.cID join OrderDetail od on o.oID = od.oID join Product p on od.pID = p.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *from Customer c left  join `Order` o on c.cID=o.cID
where o.oID is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select o.oID,o.oDate,od.odQTY*p.pPrice as GiaTien
from `order` o join orderdetail od on o.oID = od.oID join product p on od.pID = p.pID