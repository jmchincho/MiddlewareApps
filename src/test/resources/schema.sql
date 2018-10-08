DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS lesson;

create table instructor
(
	id integer not null,
	name varchar(255) not null,
	surname varchar(255) not null
);

create table lesson
(
   id integer not null auto_increment,
   title varchar(50) not null,
   instructor_id integer not null,
   hours integer not null,
   isActive Bool not null,
   level varchar(1) not null,
   primary key(id),
   FOREIGN KEY (instructor_id) REFERENCES instructor(id)
);