create database quan_ly_thu_vien;

use quan_ly_thu_vien;

create table book(
id int auto_increment primary key,
name varchar(100),
author varchar(30),
description varchar(100),
quanlity int
);

create table student(
id int auto_increment primary key,
name varchar(30),
class varchar(50)
);

create table borrow_card(
id int auto_increment primary key,
id_book int not null,
id_student int not null,
status boolean,
borrow_date date,
return_date date,
foreign key(id_book) references book(id),
foreign key(id_student) references student(id)
);

insert into book(name,author,description,quanlity) values ('Ngày xưa có một chuyện tình','Nguyễn Nhật Ánh','Truyện ngôn tình',20);
insert into book(name,author,description,quanlity) values ('Tôi thấy hoa vàng trên cỏ xanh','Nguyễn Nhật Ánh','Truyện tiểu thuyết',25);
insert into book(name,author,description,quanlity) values ('Cánh đồng bất tận','Nguyễn Ngọc Tư','Sách trừu tượng',35);
insert into book(name,author,description,quanlity) values ('Đất rừng phương Nam','Đoản Giỏi','Sách tiểu thuyết',20);
insert into book(name,author,description,quanlity) values ('Mắt biếc','Nguyễn Nhật Ánh','Sách tình cảm',10);
insert into book(name,author,description,quanlity) values ('Mùa lá rụng trong vườn','Ma Văn Kháng','Sách tiểu thuyết',15);
insert into book(name,author,description,quanlity) values ('Cho tôi xin một vé đi tuổi thơ ','Nguyễn Nhật Ánh','Sách tiểu thuyết',30);
insert into book(name,author,description,quanlity) values ('Ngồi khóc trên cây','Nguyễn Nhật Ánh','Sách trừu tượng',20);
insert into book(name,author,description,quanlity) values ('Nỗi buồn chiến tranh','Bảo Ninh','Sách tiểu thuyết',27);
insert into book(name,author,description,quanlity) values ('Cánh đồng bất tận','Phùng Quán','Sách tuổi thơ',17);

insert into student(name,class) values ('Phạm Hoàng An','C0124');
insert into student(name,class) values ('Trịnh Lưu Khoa','C0224');
insert into student(name,class) values ('Nguyễn Nhật Huy','C0124');
insert into student(name,class) values ('Nguyễn Nhật Minh','C0324');
insert into student(name,class) values ('Nguyễn Tất Quân','C0224');

insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (1, 1, 1, '2024-05-01', '2024-05-15');
insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (3, 3, 0, '2024-04-28', '2024-05-12');
insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (2, 5, 1, '2024-05-03', '2024-05-17');
insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (5, 2, 0, '2024-05-02', '2024-05-16');
insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (7, 4, 0, '2024-05-07', '2024-05-21');
insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (4, 3, 1, '2024-04-30', '2024-05-14');
insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values (6, 1, 1, '2024-05-05', '2024-05-19');

select * from book;

select * from student;

select * from borrow_card;

select * from student where id = 1;

select * from book where id = 1;

update book set quanlity = quanlity - 1 where id=1;



























