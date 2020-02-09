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
set cant_inventario='25 cajas'
where id_producto=1;

update proveedor
set nombre_empresa = 'Nestle'
where nit=12345678;


select u.usuario, u.clave
from dbo.usuarios u;


