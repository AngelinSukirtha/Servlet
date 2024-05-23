show databases;
create database registration;
use registration;
create table userRegistration(
id INT NOT NULL AUTO_INCREMENT,
name varchar(25),
mailId varchar(25),
phoneNumber varchar(10),
PRIMARY KEY (id));
insert into userRegistration(name,mailId,phoneNumber) values('Flora','ash22@gmail.com','2233445566');
insert into userRegistration(name,mailId,phoneNumber) values('Rithiga','rithi33@gmail.com','8787656543');
-- alter table userRegistration add password varchar(20);
select * from userRegistration;

drop database registration;
