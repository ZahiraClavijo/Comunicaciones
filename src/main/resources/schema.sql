create table NOTIFICATION
(
   id integer not null,
   phoneNumber varchar(9) not null,
   msg varchar(500) not null,
   status varchar(255) not null,
   primary key(id)
);