-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
select *, max(Credit) as MaxCredit 
from subject
order by Credit desc
limit 1;
-- Hiển thị các thông tin môn học có điểm thi lớn nhất
select *,max(m.Mark) as diemthilonnhat 
from `Subject` s join Mark m on s.SubID =m.SubID
group by s.SubID;  
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select *, avg(m.Mark) diemtrungbinh
from student s join Mark m on s.StudentID = m.StudentID
group by s.StudentID
order by diemtrungbinh desc;