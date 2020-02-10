use prueba;
INSERT INTO dbo.proveedor (nit, nombre_empresa)
VALUES (1023142, 'movistar');

select * from dbo.usuarios;

INSERT INTO dbo.categoria (categoria)
VALUES ('alimentos');

INSERT INTO dbo.producto (nombre, descripcion, categ_pro, prov_pro, precio_unitario, tipo_iva, cant_inventario)
VALUES ('cereal','cereal de chocolate', 1, 12345678, '$3000', '16%', '20 cajas');

select p.nombre, p.descripcion, p.categ_pro, p.prov_pro, p.precio_unitario, p.tipo_iva, p.cant_inventario
from dbo.producto p;

INSERT INTO dbo.usuarios (ID, nombre, apellido, usuario, clave)
VALUES (1143967574, 'Marcela', 'Cuellar', 'marce', 'daniel92');

select * from dbo.proveedor;

select nit, nombre_empresa from proveedor;

select p.nombre, p.descripcion, c.categoria, pr.nombre_empresa, p.precio_unitario, p.tipo_iva, p.cant_inventario
from dbo.producto p
inner join categoria c
on p.categ_pro = c.id_categoria
inner join proveedor pr
on p.prov_pro = pr.nit;

update producto
set cant_inventario='25 cajas', nombre = 'galletas', descripcion = 'Galletas de leche',
categ_pro = 1, tipo_iva = '12%', prov_pro = 12345678, precio_unitario = '2000'
where id_producto=6;

select * from producto;

update proveedor
set nombre_empresa = 'Nestle', nit = 12345
where nit=1023142;

select * from proveedor;

select u.usuario, u.clave
from dbo.usuarios u;

use prueba;
delete from dbo.producto where id_producto =6;


select * from dbo.producto;

select p.nombre, p.descripcion, p.categ_pro, p.prov_pro, p.precio_unitario, p.tipo_iva, p.cant_inventario
from dbo.producto p
where id_producto = 6;

use prueba;

select * from dbo.categoria;

delete from categoria where id_categoria in (5,6,7)

delete from categoria where id_categoria = 1;

update dbo.categoria
set categoria = 'alimentacion'
where id_categoria = 2;

delete from dbo.proveedor where nit = 12345678;


select p.nombre_empresa, p.nit
from dbo.proveedor p
where nit = 1023142;

select c.categoria, c.id_categoria
from dbo.categoria c
where id_categoria = 2;