create table pet (pet_id int4 not null, pet_location varchar(255), health_status int4, pet_name varchar(255), pet_color varchar(255), pet_length float8, pet_weight float8, user_id int4, tc_id int4, shelter_id int4, primary key (pet_id));
create table pet_type (tc_id int4 not null, category varchar(255), type varchar(255), primary key (tc_id));
create table shelter (shelter_id int4 not null, capacity int4, city varchar(255), description varchar(255), location varchar(255), shelter_name varchar(255), status boolean, zipcode int4, primary key (shelter_id));
create table track (track_id int4 not null, record_location varchar(255), record_time timestamp, pet_id int4, primary key (track_id));
create table users (user_id int4 not null, address varchar(255), email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone int8, user_name varchar(255), primary key (user_id));
alter table pet add constraint FKhg3enfwsufxjb6enqetxx2ku0 foreign key (user_id) references users;
alter table pet add constraint FKnsmlnorj1bae8xbq157963b59 foreign key (tc_id) references pet_type;
alter table pet add constraint FKdujrkamkv5tvd3sgqkpu7mwsi foreign key (shelter_id) references shelter;
alter table track add constraint FKc49xg1m9exl2hgn2km3160vr0 foreign key (pet_id) references pet;