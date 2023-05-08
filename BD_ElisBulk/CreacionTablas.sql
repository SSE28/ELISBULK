--drop table carrito, categorias,ordenes,productos,usuarios

Create table usuarios(
    ID_usuario serial primary key,
    usuario varchar(25),
    nombre varchar (50),
    apellido varchar(25),
    direccion varchar(50),
    email varchar(50),
    contraseña varchar(50),
    fechaNac date
);

Create table categorias(
    ID_categoria serial primary key,
    nombre_cate varchar(50)
);

Create table productos(
    ID_producto serial primary key,
    nombre_pro varchar(50),
    precio decimal(10,2),
    descripcion varchar(50),
    ID_categoria int,
    --cantidad int,
	foreign key (ID_categoria) references categorias(ID_categoria)

);

Create table carrito(
    ID_carrito serial primary key,
    ID_usuario int,
    ID_producto int,
    cantidad decimal(10,2),
    precio decimal(10,2),
    subtotal decimal(10,2),
    foreign key (ID_usuario) references usuarios(ID_usuario),
    foreign key (ID_producto) references productos(ID_producto)
);

--crear tabla de envio--
create table envio(
    ID_envio serial primary key,
   fecha_envio date,
fecha_entrega date,
    recibio varchar(50)
);

--crear tabla de ordenes--
Create table ordenes(
    ID_orden serial primary key,
    ID_usuario int,
    ID_producto int,
    fecha_compra DATE,
    cantidad decimal(10,2),
    precio decimal(10,2),
    direccion_envio varchar(50),
    estado varchar(50),
    subtotal decimal(10,2),
	ID_envio int,
    foreign key (ID_usuario) references usuarios(ID_usuario),
    foreign key (ID_producto) references productos(ID_producto),
	foreign key (ID_envio) references envio(ID_envio)
);



create table comentarios(
    ID_comentario serial primary key,
    ID_usuario int,
    ID_producto int,
    comentario varchar(50),
    fecha_comentario date,
    foreign key (ID_usuario) references usuarios(ID_usuario),
    foreign key (ID_producto) references productos(ID_producto)
);

--crear tabla de calificaciones--
create table calificaciones(
    ID_calificacion serial primary key,
    ID_usuario int,
    ID_producto int,
    calificacion int,
    fecha_calificacion date,
    foreign key (ID_usuario) references usuarios(ID_usuario),
    foreign key (ID_producto) references productos(ID_producto)
);

--crear tabla de promociones--
create table promociones(
    ID_promocion serial primary key,
    ID_producto int,
    promocion varchar(50),
    fecha_promocion date,
    foreign key (ID_producto) references productos(ID_producto)
);


--crear tabla de sugerencias--
create table sugerencias(
    ID_sugerencia serial primary key,
    ID_usuario int,
    ID_producto int,
    sugerencia varchar(50),
    fecha_sugerencia date,
    foreign key (ID_usuario) references usuarios(ID_usuario),
    foreign key (ID_producto) references productos(ID_producto)
);

