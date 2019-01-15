#
# Structure for table "productos"
#

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '-',
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '-',
  `precio` decimal(8,2) NOT NULL DEFAULT '0.00',
  `stock` int(11) NOT NULL DEFAULT '0',
  `paisOrigen` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '-',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

#
# Data for table "productos"
#

INSERT INTO `productos` VALUES
(1,'Case','Thermaltake Comander G42',200,100,'USA'),
(2,'Case','Corsair Crystal Series 570X RGB',540,100,'USA'),
(3,'Monitores','ASUS ROG SWIFT PG27AQ',3000,100,'USA'),
(4,'Monitores','Viewsonic VP2780-4K',1500,100,'USA'),
(5,'Perifericos','Corsair Gaming K70 RGB',300,100,'USA'),
(6,'Perifericos','Corsair M65 PRO RGB',150,100,'USA'),
(7,'Placas Madre','MSI Z270 GAMING M7',600,100,'USA'),
(8,'Placas Madre','MSI Z370 GODLIKE GAMING',1500,100,'USA'),
(9,'Tarjetas Gráficas','MSI GeForce GTX 1080 Ti GAMING X 11G',3000,100,'USA'),
(10,'Tarjetas Gráficas','MSI GeForce GTX 1080 GAMING X 8G',1800,100,'USA');
