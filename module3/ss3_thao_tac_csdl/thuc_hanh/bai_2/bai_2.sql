use quanlysinhvien;
select *from student;
select *from class;
select *from `subject`;
select *from mark;
-- Hiển thị danh sách tất cả các học viên-- 
select *from student;
-- Hiển thị danh sách các học viên đang theo học--
select *from student 
where `Status`=true;
-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ
select *from `subject` 
where credit <10;
-- Hiển thị danh sách học viên lớp A1--
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S  join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';
-- Hiển thị điểm môn CF của các học viên
select s.StudentID,s.StudentName,sub.SubName, m.Mark
from student s  join mark m on s.StudentID = m.StudentID join `Subject` sub on m.SubID = sub.SubID
where sub.SubName ='CF'; 
select student.StudentID, student.StudentName, `subject`.SubName, mark.Mark
from student, `subject`,mark
where `subject`.SubName='CF';
