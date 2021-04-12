--create table person --for jpa we don't need creating table like this
--(
--id integer not null,
--name varchar(255) not null,
--location varchar(255),
--birth_date timestamp,
--primary key(id)
--);

INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(1001,'Peter','Sydney',sysdate());
INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(1002,'James','Melbourn',sysdate());
INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(1003,'Ranga','Perth',sysdate());