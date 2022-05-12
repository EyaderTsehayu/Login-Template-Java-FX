create database addressbook;
use addressbook;
create table studentInfo(
firstName varchar (255),
lastName varchar (255),
email varchar (255)
);

create table addrsess(
id INT primary Key auto_increment,
firstName varchar (255) not null,
lastName varchar (255) not null,
email varchar (255) not null,
phoneNumber char(10) not null
);

select * from addrsess;
drop table address;


create database IESDemo;
use IESDemo;
create Table studentaccount;
select* from student_account;