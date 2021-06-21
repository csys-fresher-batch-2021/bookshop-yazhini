CREATE TABLE BookDetails(
	id serial primary key,
	bookName varchar(20) NOT NULL,
	authorName varchar(20) NOT NULL,
    bookPrice float NOT NULL,
    noOfBooks int NOT NULL
  );
select * from BookDetails;
insert into BookDetails(bookid,bookname,authorname,bookprice,noofbooks)
values(10001,'Tamil','Bharathiyar',200,20);
DELETE FROM BookDetails WHERE bookname= 'tamil';
update BookDetails set noofbooks=10 WHERE bookName ='english';


CREATE TABLE customershop(
	id serial primary key,
	userId int NOT NULL,
	CONSTRAINT customershop_user_id_fkey FOREIGN KEY (user_id)
    REFERENCES users (id),
	bookId int NOT NULL,
	bookname varchar(20) NOT NULL,
	noofbooks int NOT NULL,
    price DOUBLE PRECISION  NOT NULL,
    totalamount DOUBLE PRECISION NOT NULL,
    gstamount DOUBLE PRECISION NOT NULL
  );
select * from customershop;


CREATE TABLE registration(
	name varchar(20) NOT NULL,
	emailid varchar(20) unique NOT NULL,
    mobileno bigint NOT NULL,
    address varchar(20) NOT NULL
  );
select * from registration;
insert into registration(name,emailid,mobileno,address)
values('tamil','tamil@gmail.com',9876543456,'Gandhi street');

CREATE TABLE booking_details(
	id serial primary key,
	user_id int NOT NULL,
	   CONSTRAINT booking_details_user_id_fkey FOREIGN KEY (user_id)
       REFERENCES users (id),
	book_id int NOT NULL,
	   CONSTRAINT booking_details_book_id_fkey FOREIGN KEY (book_id)
       REFERENCES bookdetails (id),
    quantity int NOT NULL,
    totalamount DOUBLE PRECISION NOT NULL,
    ordered_date timestamp NOT NULL,
	name varchar(30) NOT NULL,
	mobileno bigint NOT NULL,
	email_id varchar (20) NOT NULL,
	address varchar (100) NOT NULL,
	status character varying(20) DEFAULT 'PENDING'
  );
 drop  table booking_details;
select * from booking_details;
insert into booking_details(user_id,book_id,quantity,totalamount,ordered_date,name,mobileno,email_id,address)
	  values(1,1,4,800,'15-06-2020 11:00:12','yazhini',9876543234,'yazh@gmail.com','7 street') ;
select u.username as username,B.bookname as book_name,bd.quantity,bd.totalamount,bd.ordered_date,bd.name,bd.mobileno,bd.address from users u,BookDetails B,booking_details bd
	where bd.user_id = u.id and bd.book_id = B.id and u.id = 3;
select u.username as username,B.bookname as book_name,bd.quantity,bd.totalamount,bd.ordered_date,bd.name,bd.mobileno,bd.address from users u,BookDetails B,booking_details bd
    where bd.user_id = u.id and bd.book_id = B.id order by ordered_date asc;
	
CREATE TABLE users(
	id serial primary key,
	userName varchar (20)NOT NULL,
	password varchar(20) NOT NULL
);
select * from users;

