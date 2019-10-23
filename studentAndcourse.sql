DROP table if exists student;
create table student(
    id int primary key not null auto_increment,
    name varchar(50) not null,
    age int not null default 18,
    score int not null
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
insert into student(name, age, score) values('杨过', 20, 100);
insert into student(name, age, score) values('楚留香', 21, 100);
insert into student(name, age, score) values('郭靖', 22, 100);
insert into student(name, age, score) values('黄蓉', 23, 100);
insert into student(name, age, score) values('小龙女', 24, 100);
insert into student(name, age, score) values('张无忌', 23, 100);


DROP table if exists course;
create table course(
    id int primary key not null auto_increment,
    name varchar(50) not null,
    score int not null
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;
insert into course(name, score) values('黯然销魂掌', 50);
insert into course(name, score) values('铁砂掌', 20);
insert into course(name, score) values('葵花宝典', 60);
insert into course(name, score) values('七伤拳', 20);
insert into course(name, score) values('乾坤大挪移', 40);
insert into course(name, score) values('九阳真经', 50);
insert into course(name, score) values('九阴真经', 50);
insert into course(name, score) values('一阳指', 30);


DROP table if exists student_course;
create table student_course(
    id int primary key not null auto_increment,
    course_id int not null,
    student_id int not null
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;