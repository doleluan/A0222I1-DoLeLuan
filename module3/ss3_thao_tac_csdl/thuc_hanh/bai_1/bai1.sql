select * from student;
select * from `subject`;
select * from class;
select * from mark;
insert into class(ClassName,StartDate,`Status`)
values ('A1', '2008-12-20', 1),
('A2', '2008-12-22', 1),
('B3', current_date, 0);
insert into student(StudentName,Address,Phone,`Status`,ClassId)
values ('Hung', 'Ha Noi', '0912113113', 1,1),
('Hoa', 'Hai phong', 1,1),
('Manh', 'HCM', '0123123123', 0,1);
insert into student(StudentName,Address,Phone,`Status`,ClassId)
values('Hoa', 'Hai phong','0988282506', 1,1);
insert into `subject`(SubName,Credit,`Status`)
values('CF', 5, 1),
       ('C', 6, 1),
       ('HDJ', 5, 1),
       ('RDBMS', 10, 1);
alter table mark add ExamTimes int;
insert into mark(SubID, StudentID,Mark, ExamTimes)
values (1, 9, 8, 1),
       (3, 10, 10, 2),
       (2, 11, 12, 1);