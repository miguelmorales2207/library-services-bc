-- SELECT * FROM LIBROS;

-- SELECT * FROM USUARIOS;

-- SELECT * FROM PRESTAMOS;

-- //------------------------------------------------- Tabla Libros

create table libros
(
	isbn varchar(10) not null,
	name varchar(30) not null,
	borrowed varchar(1) not null,
	primary key(isbn)
);

insert into libros(isbn,name,borrowed)
values('1','Poo - Java','0');

insert into libros(isbn,name,borrowed)
values('2','Artificial Intelligence','0');

insert into libros(isbn,name,borrowed)
values('3','Data Structure','0');

-- //----------------------------------------------- Tabla Usuarios

create table usuarios
(
	identificacion_usuario varchar(10) not null,
	name varchar(30) not null,
    tipo_usuario varchar(1) not null,
	primary key(identificacion_usuario)
);

insert into usuarios(identificacion_usuario,name,tipo_usuario)
values('1','Miguel Morales','1');

insert into usuarios(identificacion_usuario,name,tipo_usuario)
values('2','Camilo Gomez','2');

insert into usuarios(identificacion_usuario,name,tipo_usuario)
values('3','Diana Navia','3');

-- //--------------------------------------------- Tabla Prestamos

create table prestamos
(
    id integer(10) not null,
	isbn varchar(10) not null,
	identificacion_usuario varchar(10) not null,
    tipo_usuario integer(1) not null,
    fecha_devolucion date,
	primary key(id)
);

insert into prestamos(id, isbn, identificacion_usuario, tipo_usuario, fecha_devolucion)
values(1,'1','1',1,'2022-03-27');