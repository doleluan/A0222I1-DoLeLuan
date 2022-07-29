use quanlysinhvien;
insert into student(StudentName,Address,Phone,`Status`,ClassID) 
 values ('Nguyen Ngoc Hung','Quang Nam','',1,1),
('Huynh Tuan Khanh','Dak Lak','12345678910',1,1),
('Tran Van Nam','Gia Lai','019387921',0,2),
('Le Xuan Ky','Binh Dinh','213121379281',0,3),
('Ta Dinh Nam','Binh Dinh','213121379281',1,2);
insert into subject (SubName,Credit,`Status`)
values('HTML',3,0),
('CSS',4,1),
('JS',2,0),
('JAVA',6,1);
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * 
from student s
where s.StudentName like '% h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12
select 
* from class
where month(StartDate)=12; 
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5
select 
* from subject
where Credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2
update student
set ClassID =2
where StudentName like '% hung' or StudentName like '%hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần
select s.StudentName, sub.SubName, m.Mark
from student s join mark m on s.StudentID = m.StudentID join `Subject` sub on m.SubID = sub.SubID
order by m.Mark desc, s.StudentName;