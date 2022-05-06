/*Como crear una tabla desde SQL*/
/*Crear tablas*/
/*CREATE TABLE users (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	username VARCHAR(50) NOT NULL,
	PASSWORD VARCHAR(100) NOT null
);*/


/*INSERTAR DATOS*/
/*INSERT INTO users(username,PASSWORD) VALUES('juan','juanbe96'); */

/*Ver registros de una tabla*/


/*SELECT * FROM users;/*

/*Ver los registros, pero no todos*/
/*SELECT username from users;*/
/*
INSERT INTO users(username,PASSWORD) VALUES('root','1234');
INSERT INTO users(username,PASSWORD) VALUES('admin','12345');
INSERT INTO users(username,PASSWORD) VALUES('guess','guess');
*/

/* filtrar datos con sentencias where*/
/*SELECT * FROM users WHERE username = 'guess';*/

/*Creacion tabla articulos*/
/*
CREATE TABLE articulos(
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	titulo VARCHAR(100) NOT NULL,
	codigo VARCHAR(10) NOT NULL,
	fecha_creacion DATE NOT NULL,
	precio FLOAT NOT NULL,
	stock INT NOT NULL,
	marcas_id INT NOT NULL,
	categoria_id INT NOT null
);
*/

/*TABLAS MAESTRAS*/

/*CREATE TABLE categorias(
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	descripcion VARCHAR(100) NOT null,
	habilitada INT NOT NULL
);*/
/*
CREATE TABLE marcas(
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	descripcion VARCHAR(100),
	habilitada INT NOT NULL
);
*/

/*Insertar registros en marcas*/

/*INSERT INTO marcas (descripcion,habilitada) VALUES('Nike',1);
INSERT INTO marcas (descripcion,habilitada) VALUES('Adidas',1);

SELECT * FROM marcas;
*/
/*
INSERT INTO articulos(titulo,codigo,fecha_creacion,precio,stock,marcas_id,categoria_id)
VALUES('zapatilla nike','0000000001',CURDATE(),15000,10,1,1)
*/
/*
SELECT * FROM articulos;
*/

/* AGREGAR CAVLE FORANEA*/
/*ALTER TABLE articulos ADD CONSTRAINT FK_articulos_cagetorias FOREIGN KEY (categorias_id) 
REFERENCES categorias(id);*/

/*update*/
/*
SELECT * FROM articulos WHERE id = 1; 
UPDATE articulos SET titulo = 'ZAPATILLAS' WHERE id = 1;
*/

/* Mas ed un 1 campo */
/*
UPDATE articulos SET titulo='ZAPATILLAS', stock= 5, categorias_id=1 WHERE id =1;
*/

/*eliminar*/
/*
DELETE from cagetorias WHERE id=1*/

CREATE TABLE <nombre>

INSERT INTO <Tabla> (Campos) VALUES(valores)

UPDATE tabla SET campo1=valor1, campon=valorn WHERE cmapo = Valor

DELETE FROM tabla WHERE campo=valor

