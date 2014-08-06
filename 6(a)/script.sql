#create new db
create database minestrenght;

#use this db for operations
use minestrenght;

#create new table named user_login
create table user_login (
    user_id integer primary key auto_increment,
    user_name varchar(15) not null,
    user_pass varchar(40) not null
);

#show table definition
desc user_login;

#put records in the table
insert into user_login (user_name, user_pass) values ('admin', encode('admin', '*'));
insert into user_login (user_name, user_pass) values ('abc', encode('abc', '*'));
insert into user_login (user_name, user_pass) values ('mine', encode('yours', '*'));

#fetch records from table
select t.* from user_login t;

#fetch decoded records from table
select t.user_name 'user', decode(t.user_pass, '*') 'password' from user_login t;
