create table marca(
	id_marca int primary key,
	descripcion varchar(100) not null
);

create table presentacion(
	id_presentacion int primary key,
	descripcion varchar(50) not null
);

create table proveedor(
	id_proveedor int primary key,
	descripcion varchar(100) not null
);

create table zona(
	id_zona int primary key,
	descripcion varchar(50) not null
);

create table producto(
	id_producto int primary key,
	codigo int not null,
	descripcion_producto varchar(1000),
	precio double not null,
	stock int not null,
	iva int not null,
	peso double not null,
	id_marca int not null,
	id_presentacion int not null,
	id_proveedor int not null,
	id_zona int not null,
	/*fk_id_marca es cualquier nombre*/
	
	constraint  fk_id_marca  foreign key  (id_marca)  references marca(id_marca),
	constraint  fk_id_presentacion  foreign key  (id_presentacion)  references presentacion(id_presentacion),
	constraint  fk_id_proveedor  foreign key  (id_proveedor)  references proveedor(id_proveedor),
	constraint  fk_id_zona  foreign key  (id_zona)  references zona(id_zona)
);