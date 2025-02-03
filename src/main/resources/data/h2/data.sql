-- ******************************************************
-- 
--                       MODEL 
-- 
-- ******************************************************

INSERT INTO FAMILIAS (ID, NOMBRE) VALUES
(1, 'LICOR'),
(2, 'REFRESCO'),
(3, 'CERVEZA'),
(4, 'TAPA'),
(5, 'COMIDA'),
(6, 'POSTRE'),
(7, 'AGUA'),
(8, 'INFUSION'),
(9, 'BOCADILLO'),
(10, 'CAFE'),
(11, 'BOLLERIA'),
(12, 'ZUMO');

INSERT INTO PRODUCTOS (CODIGO, NOMBRE, DESCRIPCION, FECHA_ALTA, PRECIO, DESCATALOGADO, ID_FAMILIA) VALUES
(100,'Patatas Bravas', 'Deliciosas patatas bravas de verdad', '2017-10-21', 6.0, FALSE, 4),
(101,'Patatas Bravas XXL', 'Deliciosas patatas bravas de verdad King Size', '2017-10-23', 9.0, FALSE, 4),
(102,'Cerveza Moritz 33cl', 'La cerveza oficial de Barcelona', '2017-10-21', 3.0, FALSE, 3),
(103,'Cerveza Estrella Galicia 33cl', 'Cerveza del Norte!', '2017-10-21', 3.0, FALSE, 3),
(104,'Bocadillo de queso', null, '2017-10-25', 6.7, FALSE, 9),
(105,'Bocadillo de lomo com queso', 'Delicioso bocadillo caliente de pepito de lomo', '2017-10-16', 8.5, FALSE, 9),
(106,'Bocadillo de atún con tomate', null, '2017-10-25', 6.7, FALSE, 9),
(107,'Bocadillo de atún en escabeche con olivas', 'Bocadillo especial de la casa.', '2017-10-25', 7.0, FALSE, 9),
(108,'Biquini', 'Bocadillo sandwich caliente de jamón con queso', '2017-10-25', 7.7, FALSE, 9),
(109,'Menorquín', 'Bocadillo sandwich caliente de sobrasada y queso', '2017-10-25', 6.7, FALSE, 9),
(110,'Bocadillo serrano', 'Bocadillo de jamón se jabugo de la mejor calidad', '2017-10-25', 8.0, FALSE, 9),
(111,'Bocadillo salchichas con pimiento', 'Bocadillo caliente de salchichas con pimientos', '2017-10-22', 7.0, FALSE, 9),
(112,'Bocadillo calamares', 'Delicioso bocadillo caliente de calamares con mayonesa', '2017-10-14', 6.5, FALSE, 9),
(113,'Bocadillo de chorizo ibérico', 'Bocadillo de chorizo ibéroco de la mejor calidad', '2017-10-14', 6.9, FALSE, 9),
(114,'Bocadillo serranito', 'Bocadillo caliente de lomo con jamon serrano y pimientos verdes', '2017-10-12', 9.9, FALSE, 9),
(115,'Té verde', 'Té verde suave', '2017-10-25', 2.5, FALSE, 8),
(116,'Té rojo', 'Té rojo de gran aroma', '2017-10-25', 2.5, FALSE, 8),
(117,'Té blanco', 'Té blanco de gran aroma y fuerza', '2017-10-26', 2.5, FALSE, 8),
(118,'Manzanilla', null, '2017-10-25', 2.5, FALSE, 8),
(119,'Poleo menta', 'Poleo menta con el mejor equilbrio y aroma', '2017-10-25', 2.5, FALSE, 8),
(120,'CocaCola 33cl', 'Lata de CocaCola 33cl', '2017-10-25', 1.7, FALSE, 2),
(121,'CocaCola Zero 33cl', 'Lata de CocaCola Zero 33cl', '2017-10-26', 1.7, FALSE, 2),
(122,'Fanta Naranja 33cl', 'Lata de Fanta de Naranja de 33cl', '2017-10-25', 1.7, FALSE, 2),
(123,'Fanta Naranja Zero 33cl', 'Lata de Fanta de Naranja Zero 33cl', '2017-10-25', 1.7, FALSE, 2),
(124,'Fanta Limón 33cl', 'Lata de Fanta de Limón 33cl', '2017-10-25', 1.7, FALSE, 2),
(125,'Fanta Limón Zero 33cl', 'Lata de Fanta de Limón Zero 33cl', '2017-10-26', 1.7, FALSE, 2),
(126,'Sprite 33cl', 'Lata de Sprite 33cl', '2017-10-25', 1.7, FALSE, 2),
(127,'Aquarius 33cl', 'Lata de Aquarius 33cl', '2017-10-25', 1.9, FALSE, 2),
(128,'Tónica Sweepes 33cl', 'Lata de Tónica Sweepes 33cl', '2017-10-25', 1.7, FALSE, 2),
(129,'Botellín Tónica Sweepes 33cl', 'Botellín de Tónica Sweepes 33cl', '2017-10-11', 1.7, FALSE, 2),
(130,'Copa de Anís el Mono', 'Copita de Anís el Mono', '2017-10-20', 3.8, FALSE, 1),
(131,'Copa de Brandy Torres 5', 'Copita de Brandy Torres 5', '2017-10-21', 3.8, FALSE, 1),
(132,'Copa de Brandy Torres 10', 'Copita de Brandy Torrres 10', '2017-10-24', 4.5, FALSE, 1),
(133,'Chupito de Ballantines', 'Chupito de Ballantines', '2017-10-23', 3.8, FALSE, 1),
(134,'Copa de Ballantines con hielo', 'Copa de Ballantines con hielo', '2017-10-25', 6.0, FALSE, 1),
(135,'Cubalibre de Baccardi', 'Cubalibre de Ron Baccardi', '2017-10-23', 4.7, FALSE, 1),
(136,'Gaseosa Casera 33cl', 'Gaseosa Casera 33cl', '2017-10-25', 1.7, TRUE, 2),
(137,'Agua Viladrau 33cl', 'Botellín de Agua de Viladray 33cl', '2017-10-27', 1.2, FALSE, 7),
(138,'Agua Viladrau 1L', 'Botella de Agua de Viladray 1L', '2017-10-15', 2.3, FALSE, 7),
(139,'Agua de con gas Vichy 33cl', 'Botellín de 33cl de Agua de Vichy', '2017-10-27', 2.0, FALSE, 7),
(140,'Arroz a la Cubana', null, '2017-10-25', 6.0, FALSE, 5),
(141,'Canelones', 'Canelones de Ternera de la mejor calidad', '2017-10-25', 14.0, FALSE, 5),
(142,'Canelones de espinacas', 'Canelones de espinacas', '2017-10-25', 12.5, FALSE, 5),
(143,'Crema de Calabacín', null, '2017-10-25', 9.0, FALSE, 5),		
(144,'Lentejas Estofadas', 'Lentejas Estofadas con chorizo', '2017-10-25', 12.0, FALSE, 5),
(145,'Solomillo de ternera con patatas', 'Solomillo tierno de la mejor calidad', '2017-10-25', 17.5, FALSE, 5),
(146,'Rape a la Marinera', 'Rape a la Marinena especialidad de la casa', '2017-10-25', 18.2, FALSE, 5),
(147,'Pollo Jimmy Carter', 'Delicioso pollo al estilo tejano con salsa de cacahuetes', '2017-10-25', 12.0, FALSE, 5),
(148,'Pollo Kim Jong-un', 'Delicioso pollo al estilo coreano', '2017-10-25', 12.0, FALSE, 5),
(149,'Pollo Fidel', 'Delicioso pollo al estilo cubano con salsa timba.', '2017-10-25', 12.0, FALSE, 5),
(150,'Pollo Ranchero', 'Delicioso pollo asado con salsa molcajete al estilo mexicano.', '2017-10-25', 12.0, FALSE, 5),
(151,'Pollos Asados Hermanados', 'Deliciosas raciones de pollo para compartir en grupo. La especialidad de la casa.', '2017-10-25', 15.0, FALSE, 5),
(152,'Olivas rellenas', 'Olivas rellenas de anchoa extra', '2017-10-25', 2.6, FALSE, 4),
(153,'Pimientos del padrón', 'Pimientos del padrón fritos.', '2017-10-25', 3.8, FALSE, 4),
(154,'Mejillón Tigre (unidad)', 'Mejillón rebozado en nuestra cocina', '2017-10-25', 2.4, FALSE, 4),
(155,'Mejillones al vapor', 'Mejillones al vapor', '2017-10-25', 6.6, FALSE, 4),
(156,'Café Solo', 'Café Solo', '2017-10-25', 1.5, FALSE, 10),
(157,'Café Americano', 'Café Americano', '2017-10-16', 1.8, FALSE, 10),
(158,'Café Solo Descafeinado', 'Café Descafeinado', '2017-10-25', 1.5, FALSE, 10),
(159,'Café Cortado', 'Café Cortado', '2017-10-25', 2.0, FALSE, 10),
(160,'Café Cortado Descafeinado', 'Café Cortado Descafeinado', '2017-10-25', 2.0, FALSE, 10),
(161,'Café con Leche', 'Café con Leche', '2017-10-14', 2.5, FALSE, 10),
(162,'Café con Leche Descafeinado', 'Café con Leche Descafeinado', '2017-10-14', 2.5, FALSE, 10),
(163,'Croissant', 'El mejor Croissant de Barcelona!', '2017-10-12', 2.7, FALSE, 11),
(164,'Croissant de chocolate', 'El mejor Croissant de Barcelona!', '2017-10-11', 2.9, FALSE, 11),
(165,'Ensaimada', null, '2017-10-25', 2.7, FALSE, 11),
(166,'Donut', null, '2017-10-25', 2.7, FALSE, 11),
(167,'Madalena Integral', null, '2017-10-25', 2.7, FALSE, 11),
(168,'Madalena Integral Pequeña', null, '2017-10-25', 1.5, FALSE, 11),
(169,'Pastéis de Belem (2 piezas)', 'Deliciosos pastelitos traidos en helicoptero cada mañana desde Lisboa.', '2018-10-22', 3.5, FALSE, 11);

INSERT INTO ESTABLECIMIENTOS (NIF,
							  NOMBRE_COMERCIAL,
							  DIRECCION,
							  POBLACION,
							  PROVINCIA,
							  CODIGO_POSTAL,
							  PAIS,
							  TELEFONO,
							  MOVIL,
							  EMAIL,
							  FECHA_INAUGURACION) VALUES
('B38983321', 'Gran Via 2', 'Gran Via de Les Corts Catalanes, 345', 'Barcelona', 'Barcelona','08034', 'España', '+34 932247078', null, 'granvia2@pollosfelices.com', '2003-10-20'),
('B00177845', 'Vaguada', 'Av. de Monforte de Lemos, 36', 'Madrid', 'Madrid','28029', 'España', '+34 913682828', '620897644', 'lavaguada@pollosfelices.com', '2011-08-14');

INSERT INTO PERSONAS(CODIGO, 
					 DNI,
					 NOMBRE,
					 APELLIDO1,
					 APELLIDO2,
					 DIRECCION,
					 POBLACION,
					 CODIGO_POSTAL,
					 PROVINCIA,
					 PAIS,
					 TELEFONO,
					 MOVIL,
					 EMAIL) VALUES
(10, '45899812L', 'Marta', 'Quesada', 'Olmos', 'c/Marina, 234 2º 1ª', 'Barcelona', '08014', 'Barcelona', 'España', '932318811', null, 'apax344@hotmail.com'),
(11, '30092765K', 'José Ramón', 'Peña', 'Ojeda', 'c/Muntaner, 230 ', 'Barcelona', '08020', 'Barcelona', 'España', '93 2209088', '620109034', 'jr200@gmail.com'),
(12, '45011723P', 'Carlos Jesús', 'Olmedo', 'Cierco', null, 'Madrid', null, 'Madrid', 'España', null, null, 'carlosj20@gmail.com'),
(13, 'X58993234', 'Walter', 'Peralta', null, 'c/ Juan Soldevila, 34 ático 1', 'Teruel', '28933', 'Teruel', 'España', '982209090', null, 'jsprod34@hotmail.com'),
(14, '40922311S', 'Anna', 'Balcells', 'Rius', 'Avda. Del Roble, 230', 'Santa Coloma de Gramanet', '08921', 'Barcelona', 'España', '934567809', '609908756', 'balc.rius@hotmail.com'),
(15, '30998123T', 'Enric', 'Balcells', 'Rius', 'c/ Republica 201', 'Barcelona', '08003', 'Barcelona', 'España', '932209012', null, 'enric.enric@hotmail.com');

INSERT INTO CLIENTES(CODIGO, GOLD) VALUES
(10, true),
(12, false);

INSERT INTO EMPLEADOS(CODIGO, LICENCIA_MANIPULADOR_ALIMENTOS) VALUES
(11, 'LMA200912T'),
(13, 'LMA009200S'),
(14, 'LMA201222R'),
(15, 'LMA200001T');

INSERT INTO PEDIDOS (CODIGO, FECHA_HORA, CODIGO_EMPLEADO, ESTADO, CODIGO_CLIENTE, NIF_ESTABLECIMIENTO) VALUES
(1000, '2023-04-17 09:01:42.069', 11, 'SERVIDO', null, 'B38983321'),
(1001, '2023-04-17 09:05:13.012', 13, 'SERVIDO', null, 'B00177845'),
(1002, '2023-04-17 09:12:11.134', 11, 'SERVIDO', null, 'B38983321'),
(1003, '2023-04-17 09:22:02.234', 15, 'CANCELADO', null, 'B00177845'),
(1004, '2023-04-17 09:23:17.123', 11, 'SERVIDO', null, 'B38983321'),
(1005, '2023-04-17 09:25:39.009', 11, 'SERVIDO', null, 'B38983321'),
(1006, '2023-04-17 09:31:23.204', 15, 'SERVIDO', null, 'B38983321'),
(1007, '2023-04-17 09:37:43.401', 11, 'SERVIDO', 10, 'B38983321'),
(1008, '2023-04-17 09:42:54.403', 15, 'SERVIDO', null, 'B00177845'),
(1009, '2023-04-17 09:48:33.500', 11, 'SERVIDO', null, 'B38983321'),
(1010, '2023-04-17 09:51:19.030', 11, 'EN_PROCESO', null, 'B38983321'),
(1011, '2023-04-17 09:58:13.509', 13, 'SERVIDO', null, 'B38983321'),
(1012, '2023-04-17 10:00:07.124', 11, 'PENDIENTE_ENTREGA', 10, 'B38983321'),
(1013, '2023-04-17 10:06:10.222', 13, 'PENDIENTE_ENTREGA', null, 'B38983321'),
(1014, '2023-04-17 10:14:51.298', 15, 'NUEVO', null, 'B00177845');

UPDATE PEDIDOS SET comentario = 'No incluir servilletas' WHERE CODIGO = 1000;
UPDATE PEDIDOS SET comentario = 'Vasos con hielo' WHERE CODIGO = 1011;

INSERT INTO LINEAS_PEDIDO (CODIGO_PEDIDO, ORDEN, CODIGO_PRODUCTO, CANTIDAD, PRECIO) VALUES
(1000, 0, 100, 2, 6.0),
(1000, 1, 103, 8, 3.0),
(1001, 0, 102, 1, 3.0),
(1002, 0, 137, 2, 1.2),
(1002, 1, 108, 1, 7.7),
(1002, 2, 115, 1, 2.5),
(1002, 3, 120, 1, 1.7),
(1003, 0, 159, 1, 2.0),
(1003, 1, 137, 1, 1.2),
(1004, 0, 108, 1, 7.7),
(1004, 1, 103, 1, 3.0),
(1004, 2, 105, 1, 8.5),
(1004, 3, 137, 1, 1.2),
(1004, 4, 156, 3, 1.5),
(1005, 0, 156, 2, 1.5),
(1006, 0, 156, 2, 1.5),
(1006, 1, 158, 1, 1.5),
(1006, 2, 120, 1, 1.7),
(1006, 3, 104, 1, 6.7),
(1007, 0, 156, 3, 1.5),
(1007, 1, 158, 1, 1.5),
(1007, 2, 115, 1, 2.5),
(1007, 3, 110, 2, 8.0),
(1007, 4, 139, 1, 2.0),
(1007, 5, 121, 1, 1.7),
(1007, 6, 111, 1, 7.0),
(1007, 7, 103, 2, 3.0),
(1007, 8, 161, 2, 2.5),
(1007, 9, 162, 1, 2.5),
(1008, 0, 159, 2, 2.0),
(1008, 1, 163, 1, 2.6),
(1008, 2, 137, 3, 1.2),
(1008, 3, 109, 1, 6.7),
(1008, 4, 161, 1, 2.5),
(1008, 5, 117, 1, 2.5),
(1009, 0, 166, 1, 2.7),
(1009, 1, 157, 1, 1.8),
(1009, 2, 162, 1, 2.5),
(1010, 0, 107, 1, 7.0),
(1010, 1, 120, 1, 1.7),
(1010, 2, 156, 1, 1.5),
(1011, 0, 167, 1, 2.7),
(1011, 1, 161, 1, 2.5),
(1012, 0, 159, 1, 2.0),
(1012, 1, 161, 2, 2.5),
(1013, 0, 159, 2, 2.0),
(1013, 1, 164, 1, 2.9),
(1013, 2, 157, 1, 1.8),
(1014, 0, 108, 1, 7.7),
(1014, 1, 103, 1, 3.0),
(1014, 2, 166, 1, 2.7),
(1014, 3, 156, 3, 1.5),
(1014, 4, 102, 2, 2.5);

-- ******************************************************
-- 
--                  SPRING SECURITY 
-- 
-- ******************************************************

INSERT INTO ROLES (ID, NAME) VALUES (1, 'SUPER_ADMIN');
INSERT INTO ROLES (ID, NAME) VALUES (2, 'ADMIN');
INSERT INTO ROLES (ID, NAME) VALUES (3, 'CLIENTE');

/*
  	role						        username	password        enabled
 	========================================================================================================
 	SUPER_ADMIN, ADMIN, CLIENTE	    	u1		    password
 	SUPER_ADMIN, ADMIN	    	        u2		    password
 	SUPER_ADMIN			                u3		    password
 	ADMIN			                    u4		    password
 	CLIENTE                        		u5   	    password
 	CLIENTE		                        u6		    password		(this user is disabled)
 */

INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, TELEFONO, ENABLED, LAST_PASSWORD_RESET_DATE) VALUES
(1, 'u1', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Pepín', 'Gálvez Ridruejuela', 'u1@gmail.com', '+34 636598871', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy')),
(2, 'u2', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Montse', 'Queralt Conejero', 'pingo@pingo.com','687253062', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy')),
(3, 'u3', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Carlota', 'Fernández Olaz', 'pingo@pingo.com','962207855', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy')),
(4, 'u4', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Honorio', 'Martín Salvador', 'disabled@user.com', '607253012', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy')),
(5, 'u5', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Marta', 'Olmos Medina', 'marta@admin.com','93220909872', 1, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy')),
(6, 'u6', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'José Ramón', 'Fernández Grimal', 'admin@admin.com','629457021', 0, PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));

INSERT INTO USER_ROLES (ID_USER, ID_ROL) VALUES
(1,1),
(1,2),
(1,3),
(2,1),
(2,2),
(3,1),
(4,2),
(5,3),
(6,3);

