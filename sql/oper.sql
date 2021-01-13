CREATE TABLE grupo(id INT PRIMARY KEY,
		   nombre VARCHAR(100),
		   descripcion TEXT);



CREATE TABLE articulo(id INT PRIMARY KEY,
				   nombre VARCHAR(100),
				   cantidad_actual INT,
				   precio_venta FLOAT,
				   costo_ponderado FLOAT,
				   id_grupo INT);#id_grupo is foreign key to grupo


CREATE TABLE movientos(id INT PRIMARY KEY,
				   	   id_articulo INT,#this is a foreign key to article
				   	   tipo VARCHAR(100),
				   	   precio FLOAT,
				   	   fecha DATE);
CREATE TABLE cliente(cc varchar(100) PRIMARY KEY,
					 nombre varchar(100),
					 telefono varchar(20),
					 direccion varchar(80));
CREATE TABLE credito(id INT PRIMARY KEY,
					 id_cliente VARCHAR(100),
					 lista_productos TEXT,#i set lista_productos to TEXT field because i think all product save in string
					 cantidad_productos TEXT,#i explain this in the next meeting
					 total FLOAT,
					 deuda FLOAT);
CREATE TABLE factura(id INT PRIMARY KEY,
					 lista_producto TEXT,
					 lista_cantidad TEXT,
					 lista_precio_unit TEXT,
					 total FLOAT
					 );
					 
					#id_cliente is a possible argument to the table, its function continue in discuss
					#nombre is a possible argument to the table, its function continue in discuss
					#telefono is a possible argument to the table, its function continue in discuss
					#direccion is a possible argument to the table, its function continue in discuss
