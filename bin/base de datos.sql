
use programacion1tarea8;
create table agenda
 (
nombre varchar (150),
fecha date,
mensaje text (150)
);
insert into agenda values ('alenjandro','2022-04-20', 'feliz cumple años');
insert into agenda values ('MARIANO','2022-04-10', ' anos');
select * from agenda;
select fecha from agenda;
drop table agenda;
show variables where variable_name in ('hostname','port','password()')