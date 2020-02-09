create database factory_hka;

use prueba;
create table usuarios(
ID			INT			NOT NULL	PRIMARY KEY,
nombre		VARCHAR(20)	NOT NULL,
apellido	VARCHAR(30)	NOT NULL,
usuario		VARCHAR(20)	NOT NULL,
clave		VARCHAR(30)	NOT NULL
);


use prueba;
CREATE TABLE proveedor (
nit				NUMERIC(15)		NOT NULL		PRIMARY KEY,
nombre_empresa	VARCHAR(50)		NOT NULL
);

use prueba;
CREATE TABLE categoria (
id_categoria		INT				IDENTITY(1,1)	NOT NULL	PRIMARY KEY,
categoria			VARCHAR(50)		NOT NULL
);

use prueba;
CREATE TABLE producto (
id_producto		INT				IDENTITY(1,1)	NOT NULL	PRIMARY KEY,
nombre			VARCHAR(25)		NOT NULL,
descripcion		VARCHAR(100)	NOT NULL,
categ_pro		INT				NOT NULL,
prov_pro		NUMERIC(15)		NOT NULL,
precio_unitario	VARCHAR(20)		NOT NULL,
tipo_iva		VARCHAR(30)		NOT NULL,
cant_inventario	VARCHAR(30)		NOT NULL,
CONSTRAINT FK_produc_categ FOREIGN KEY (categ_pro)
REFERENCES categoria(id_categoria),
CONSTRAINT FK_produc_prov FOREIGN KEY (prov_pro)
REFERENCES proveedor(nit)
);

CREATE TABLE orden_compra (

);
use prueba;
CREATE TABLE factura (
nro_factura		INT				IDENTITY(1,1)	NOT NULL	PRIMARY KEY,
nit				NUMERIC(15)		NOT NULL,
tasa_iva		VARCHAR(10)		NOT NULL,
);
