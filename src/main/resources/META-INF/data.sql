INSERT INTO MENU (nombre) VALUES('DESCRIPCION5')
INSERT INTO MENU (nombre) VALUES('DESCRIPCION2')
INSERT INTO MENU (nombre) VALUES('DESCRIPCION3')
INSERT INTO MENU (nombre) VALUES('DESCRIPCION4')

INSERT INTO PERSONA (apellidos,correo,direccion,dni,nombres,sexo,telefono ) VALUES('PONCE1','CORREO1','DIRECCION1','DNI1','NOMBRES1','M','TELEFONO1')
INSERT INTO PERSONA (apellidos,correo,direccion,dni,nombres,sexo,telefono ) VALUES('PONCE2','CORREO2','DIRECCION2','DNI2','NOMBRES2','M','TELEFONO2')
INSERT INTO PERSONA (apellidos,correo,direccion,dni,nombres,sexo,telefono ) VALUES('PONCE3','CORREO3','DIRECCION3','DNI3','NOMBRES3','F','TELEFONO3')

insert into menuitem(idMenu, nombre,url) values(1,'indice','sddsd')
insert into menuitem(idMenu, nombre,url) values(1,'configura','ededede')

insert into area(descripcion, nombre) values('aca hay uno','contabilidad')
insert into area(descripcion, nombre) values('aca hay dos','logistica')
insert into area(descripcion, nombre) values('aca hay tres','tesoreria')
insert into area(descripcion, nombre) values('aca hay cuatro','alamacen')
insert into area(descripcion, nombre) values('aca hay quinto','administracion')



insert into perfil (nombre, descripcion) values('uno','unos')
insert into perfil (nombre, descripcion) values('dos','doces')
insert into perfil (nombre, descripcion) values('tres','treces')
insert into perfil (nombre, descripcion) values('cuatro','cuatros')
insert into perfil (nombre, descripcion) values('cinco','cincos')

insert into usuario (idUsuario,estado, password,username,idPerfil,idPersona) values(1,'1','poderoso','rponce','1','1')
insert into usuario (idUsuario,estado, password,username,idPerfil,idPersona) values(2,'0','poderoso','bartimeo','2','2')
insert into usuario (idUsuario,estado, password,username,idPerfil,idPersona) values(3,'1','poderoso','caleb','3','3')

insert into tipotramite(descripcion, cantMovimientos) values('pago',1)
insert into tipotramite(descripcion, cantMovimientos) values('certificacion',2)
insert into tipotramite(descripcion, cantMovimientos) values('servicios',3)
insert into tipotramite(descripcion, cantMovimientos) values('devolucion',4)


insert into itemtipotramite(item, plazo,idArea,idTipoTramite) values(1,1,1,1)
insert into itemtipotramite(item, plazo,idArea,idTipoTramite) values(2,2,2,2)
insert into itemtipotramite(item, plazo,idArea,idTipoTramite) values(3,3,3,3)
insert into itemtipotramite(item, plazo,idArea,idTipoTramite) values(4,4,4,4)


insert into cargo(idArea,nombre,jefearea) values(1,'administrador','1')
insert into cargo(idArea,nombre,jefearea) values(2,'contador','0')
insert into cargo(idArea,nombre,jefearea) values(3,'especialista','1')
insert into cargo(idArea,nombre,jefearea) values(4,'especialsita','0')


