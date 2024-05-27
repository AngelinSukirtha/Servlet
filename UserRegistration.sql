show databases;
create database registration;
use registration;
create table userRegistration(
id INT NOT NULL AUTO_INCREMENT,
name varchar(25),
mailId varchar(25),
phoneNumber varchar(10),
PRIMARY KEY (id));
insert into userRegistration(name,mailId,phoneNumber) values('Flora','flo22@gmail.com','2233445566');
insert into userRegistration(name,mailId,phoneNumber) values('Rithiga','rithi33@gmail.com','8787656543');
-- alter table userRegistration add password varchar(20);
select * from userRegistration;

create table userLogin(
id INT NOT NULL AUTO_INCREMENT,
userName varchar(25),
email varchar(25),
PRIMARY KEY (id));

insert into userLogin(userName,email) values('Flora','flo22@gmail.com');
insert into userLogin(userName,email) values('Rithiga','rithi33@gmail.com');
select * from userLogin;

drop database registration;
