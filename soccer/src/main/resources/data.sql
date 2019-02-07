
insert into state values(1,'MI');
insert into state values(2,'VA');
insert into user(id,email,first_name,last_name,
location, state, password) values(10000, 'edgnet@gmail.com','Edgar','Paz',
'Farmington', 1,'1234');
insert into user(id,email,first_name,last_name,
location, state, password) values(10001, 'edgnet2@gmail.com','Eduardo','Perez',
'Detroit', 1,'1234');

insert into event(id, name, date,location,state_id,host_id) values(10000, 'Movie Night' , sysdate, 'Richmont', 2,10000);
insert into event(id, name, date,location,state_id,host_id) values(10001, 'Cooking Leson' , sysdate, 'Farmington', 1,10000);
insert into event_messages(id, event_id, user_id, message) values(10000,10000,10000, 'Mensaje de ed');
insert into event_messages(id, event_id, user_id, message) values(10001,10000,10000, 'Mensaje de ed2');
create table event_members(event_id integer, user_id integer);
insert into event_members values(10000,10001);
