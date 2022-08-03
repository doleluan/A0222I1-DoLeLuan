use quanlysinhvien;
-- Hiển thị số lượng sinh viên ở từng nơi
select Address, count(StudentID) as soluong
from student
group by Address;
-- Tính điểm trung bình các môn học của mỗi học viên
select s.StudentID,s.StudentName,avg(m.Mark) as trungbinh
from student s join mark m on s.StudentID = m.StudentID
group by  s.StudentID,s.StudentName;
-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
select s.StudentID,s.StudentName,sub.SubName,avg(m.Mark) as trungbinh
from student s join mark m on s.StudentID = m.StudentID join `Subject` sub on sub.SubID= m.SubID
having trungbinh>15;
alter table Mark add foreign key (SubID)  references `Subject` (SubID);
alter table Mark add foreign key (StudentId)  references Student (StudentID);
-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất
select s.StudentID,s.StudentName,sub.SubName,max(m.Mark) as diemlonnhat
from student s join mark m on s.StudentID = m.StudentID join `Subject` sub on sub.SubID= m.SubID
order by diemlonnhat desc
limit 1;

