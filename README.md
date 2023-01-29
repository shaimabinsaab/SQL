# SQL
create database store;

create table countries(
    code varchar(25)primary key ,
    name varchar(20)unique ,
    continent_name varchar(20)not null
);
DROP TABLE countries;

create table countries(
    code int(25)primary key ,
    name varchar(20)unique ,
    continent_name varchar(20)not null
);
create table users(
    id int primary key ,
    full_name varchar(20),
    email varchar(20)unique ,
    gender char(1)check ( gender='m' or gender='f'),
    date_of_birth varchar(15),
    created_at datetime,
    country_code int,
    foreign key (country_code)references countries(code)
);

create table orders(
    id int primary key ,
    user_id int,
    status varchar(6)check ( status='start' or status='finish'),
    foreign key (user_id) references users(id)
);

create table products(
    id int primary key ,
    name varchar(10)not null ,
    price int default 0,
    statue varchar(10)check ( statue='valid'or statue='expired' ),
    Date datetime default CURRENT_TIMESTAMP


);
create table order_product(
    order_id int,
    product_id int,
    quantity int default 0,
    foreign key (order_id)references orders(id),
    foreign key (product_id)references products(id)
);

insert into countries values (1,'shaima','asia');
insert into users values (1,'shahad','shaiam@gmail.com','f','june','2011-03-12',1);
insert into orders values (1,1,'start');
insert into products values (1,'reema',50,'valid','18-06-12 10:34:09');
insert into order_product values (1,1,20);
update countries set countries.name='leena'where countries.code=1;
delete from products where id=1;
