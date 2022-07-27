-- create database quanlysinhvien;
use quanlysinhvien;
create table Class (
ClassID int primary key auto_increment,
ClassName varchar(60) not null,
StartDate datetime not null,
`Status` bit
);
create table Student (
StudentID int primary key auto_increment,
StudentName varchar(30) not null,
Address varchar(50),
Phone varchar(20), 
`Satatus` Bit,
ClassID int not null,
foreign key(ClassID) references Class(ClassID)
);
create table `SubJect`(
SubID int primary key auto_increment,
SubName varchar(30) not null,
Credit tinyint not null default 1 check (credit >=1),
`Status` bit default 1
);
create table Mark(
MarkID int primary key auto_increment,
SubID int not null unique,
StudentID int not null  unique,
Mark float default 0 check (Mark between 0 and 100),
FOREIGN KEY (SubId) REFERENCES `Subject` (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
 
);