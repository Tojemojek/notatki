-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mojeallegro
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,2) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1902 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'laptop',3630.00),(2,'mysz',61.00),(3,'klawiatura',121.00),(4,'ściereczki do ekranu',24.00),(5,'krzesło',605.00),(6,'biurko',1452.00),(7,'książka',61.00),(902,'Green',15.00),(903,'Loquat',34.00),(904,'Mix Pina Colada',61.00),(905,'Magnotta  White',14.00),(906,'Greek Salad',45.00),(907,'Havarti  Roasted Garlic',92.00),(908,'Boston Clam Chowder',41.00),(909,'Navy  Dry',97.00),(910,'White  Lindemans Bin 95',9.00),(911,'Beef Dry Aged Tenderloin Aaa',73.00),(912,'Provolone',12.00),(913,'Inside Round / Top  Lean',93.00),(914,'Periguita Fonseca',15.00),(915,'Strawberry  20 Ml Jar',96.00),(916,'Country Roll',36.00),(917,'Halves',108.00),(918,'Cakes Assorted',50.00),(919,'Black Tiger 26/30',30.00),(920,'Rootbeer',68.00),(921,'Gold Formel',23.00),(922,'Panko',42.00),(923,'Pepper Portions',62.00),(924,'Anchovy Fillets',19.00),(925,'Red  Cabernet Sauvignon',4.00),(926,'Pickled',38.00),(927,'Dark Roast',91.00),(928,'Blue Curacao',85.00),(929,'Peller Estates Late',71.00),(930,'Inside',59.00),(931,'White Fish',43.00),(932,'Sesame Seed Presliced',11.00),(933,'Zinfandel California 2002',87.00),(934,'Fettuccine  Dry',96.00),(935,'Smoked',54.00),(936,'Camerons Auburn',53.00),(937,'Smoked Salmon / Dill',109.00),(938,'Fuji',49.00),(939,'Kumquat',28.00),(940,'Amarula Cream',27.00),(941,'Hot',12.00),(942,'White',73.00),(943,'Italian Roll With Herbs',13.00),(944,'White  Sliced',1.00),(945,'Knorr  Chicken Gumbo',74.00),(946,'White  Gg White',35.00),(947,'Asian',69.00),(948,'Table',10.00),(949,'Crackers Cheez It',10.00),(950,'Sour Batard',109.00),(951,'Mini',14.00),(952,'Almond  Blanched  Ground',73.00),(953,'Gouda',21.00),(954,'Dawn Professionl Pot And Pan',110.00),(955,'Brandy Apricot',54.00),(956,'Chips Potato Swt Chilli Sour',3.00),(957,'Assorted Teas',86.00),(958,'Green',28.00),(959,'Melba Toast',63.00),(960,'Seaweed Green Sheets',93.00),(961,'Multigrain Oval',78.00),(962,'Smarties',63.00),(963,'Invert',95.00),(964,'Loin Chops',70.00),(965,'Assorted Rolls',93.00),(966,'Baking Cups',60.00),(967,'Natural  591 Ml',68.00),(968,'7  Paper',99.00),(969,'Neutral',64.00),(970,'Ricotta',106.00),(971,'Graham Cracker Mix',47.00),(972,'Roasted  Cooked',14.00),(973,'Schweppes  355 Ml',69.00),(974,'Mineral  Natural',48.00),(975,'Andouille',79.00),(976,'Halves',85.00),(977,'Golden',49.00),(978,'Anjou',105.00),(979,'Worcestershire Sauce',87.00),(980,'Chocolate',30.00),(981,'Cornish Hen',71.00),(982,'Hersey Shakes',58.00),(983,'Regular',73.00),(984,'Salad Dressing',81.00),(985,'Ocean Spray Cranberry',45.00),(986,'Sperone  Fine  D.o.c.',17.00),(987,'Enoki  Fresh',20.00),(988,'Water',68.00),(989,'Leg  Boneless',59.00),(990,'Strawberry',90.00),(991,'Brick With Pepper',103.00),(992,'Fontanafredda Barolo',18.00),(993,'Englishbay Wht',11.00),(994,'Cool Blue Raspberry',38.00),(995,'Curry Powder',96.00),(996,'Pizza Pizza Dough',90.00),(997,'Mikroklene 4/4 L',81.00),(998,'Pork Casing',53.00),(999,'Red Pepper Paste',95.00),(1000,'English Muffin',5.00),(1001,'Dill',85.00),(1002,'Top Sirloin',104.00),(1003,'Bernaise  Mix',83.00),(1004,'Currants',43.00),(1005,'Jasmin Green',14.00),(1006,'Tenderloin',44.00),(1007,'Mountain Dew',3.00),(1008,'Filets',98.00),(1009,'Primerba  Paste',32.00),(1010,'Sardines',14.00),(1011,'Sweet  4',69.00),(1012,'Mcguinness',43.00),(1013,'Whole Head Off nz',30.00),(1014,'Magarita Mix',36.00),(1015,'Raspberry',90.00),(1016,'Instant Coffee',35.00),(1017,'Glass Clear 8 Oz',69.00),(1018,'Tubes / Tenticles 10/20',57.00),(1019,'Paulaner Hefeweisse',4.00),(1020,'Cutting',107.00),(1021,'Kidney  Red Dry',98.00),(1022,'Lasagna Noodle  Frozen',14.00),(1023,'Kaffir Lime Leaves',64.00),(1024,'Mayonnaise',96.00),(1025,'China Rose',36.00),(1026,'Oven Roast Breast',109.00),(1027,'Herbal I Love Lemon',60.00),(1028,'Pecan  Halves',69.00),(1029,'Mcguinness',95.00),(1030,'Hot  Lnferno',57.00),(1031,'Red',78.00),(1032,'Tea Peppermint',60.00),(1033,'Cornflakes',86.00),(1034,'Mangoes',49.00),(1035,'Longan',69.00),(1036,'Primerba  Paste',23.00),(1037,'Jerusalem Artichoke',16.00),(1038,'Raisin Walnut Oval',81.00),(1039,'8  Paper',74.00),(1040,'Tobasco Sauce',20.00),(1041,'English Muffin',22.00),(1042,'Canned  Flaked  Light',102.00),(1043,'Clam Chowder  Dry Mix',96.00),(1044,'Fillets',63.00),(1045,'Creemore',95.00),(1046,'Cookie Trail Mix',83.00),(1047,'Whole',80.00),(1048,'Roll  Whole Wheat',104.00),(1049,'Chops  Split  Frenched',90.00),(1050,'Tomatoes Tear Drop',81.00),(1051,'Base Broth Beef',17.00),(1052,'Herbal',28.00),(1053,'Mango Maddness',16.00),(1054,'Liver',62.00),(1055,'Kaffir Lime Leaves',82.00),(1056,'Red Currants',8.00),(1057,'Magnotta',38.00),(1058,'Port Late Bottled Vintage',10.00),(1059,'Dungeness  Whole',13.00),(1060,'Almond Amaretto',70.00),(1061,'Frozen Basket Variety',2.00),(1062,'Purple  Organic',15.00),(1063,'Blueberry Individual',41.00),(1064,'Frozen',60.00),(1065,'Campari',54.00),(1066,'Tribal Sauvignon',14.00),(1067,'29 Foot',43.00),(1068,'Steampan Lid',78.00),(1069,'Lamb Shoulder Boneless Nz',77.00),(1070,'White  Ej',67.00),(1071,'Rice Flour',29.00),(1072,'Fresh',61.00),(1073,'Basmati',24.00),(1074,'Orange',95.00),(1075,'Wasabi Powder',94.00),(1076,'Beverge  White 2',74.00),(1077,'Almond',89.00),(1078,'Life Savers',17.00),(1079,'Leather Leaf Fern',39.00),(1080,'Melba Toast',87.00),(1081,'Mini French Pastries',12.00),(1082,'Fresh',77.00),(1083,'Individual',2.00),(1084,'Bones',99.00),(1085,'Table Cloth 91x91 Colour',103.00),(1086,'Pumpernickle  Rounds',63.00),(1087,'Courvaisier',47.00),(1088,'Roll  Soft White Round',85.00),(1089,'Crawfish',60.00),(1090,'Whole White Sesame',12.00),(1091,'Ched Chs Presliced',20.00),(1092,'Chocolate',98.00),(1093,'Foil',9.00),(1094,'Lemons',69.00),(1095,'Black Tiger 16/20',79.00),(1096,'Butt  Boneless',92.00),(1097,'Plum',29.00),(1098,'Chutney Sauce',7.00),(1099,'Black Tiger 8',42.00),(1100,'Flavouring Vanilla Artificial',74.00),(1101,'White Grape',90.00),(1102,'Crab Brie In Phyllo',79.00),(1103,'Wax',6.00),(1104,'Unsweetened',11.00),(1105,'Scallops 60/80 Iqf',13.00),(1106,'Tarragon',57.00),(1107,'Ej Gallo Sierra Valley',27.00),(1108,'Mcguinness',62.00),(1109,'Mocha',53.00),(1110,'Bag Clear 10 Lb',98.00),(1111,'Peach Daiquiri',90.00),(1112,'Paprika',62.00),(1113,'Enoki  Fresh',62.00),(1114,'Plain Fried Rice',104.00),(1115,'Gold Formel',91.00),(1116,'Wine  Plastic  Clear 5 Oz',34.00),(1117,'White Paper',82.00),(1118,'Scotch Bonnet',109.00),(1119,'Maipo Valle Cabernet',76.00),(1120,'Brights  Dry',62.00),(1121,'Cubes',32.00),(1122,'Passion Fruit',75.00),(1123,'Long Island Ice Tea',14.00),(1124,'Dibs',75.00),(1125,'Kaffir Lime Leaves',81.00),(1126,'Blood Pudding',110.00),(1127,'Fino Tio Pepe Gonzalez',91.00),(1128,'Cactus Pads',87.00),(1129,'Plain',15.00),(1130,'Reese Pieces',105.00),(1131,'Sambuca Cream',5.00),(1132,'Green Tea',94.00),(1133,'Yukon Gold 5 Oz',52.00),(1134,'Espresso',13.00),(1135,'Cherry  Yellow',99.00),(1136,'Tomato Puree',110.00),(1137,'Apple Large',47.00),(1138,'Gouda Smoked',56.00),(1139,'Knorr  Veg / Beef',93.00),(1140,'Cooked',44.00),(1141,'Crimini',84.00),(1142,'Whole  Boneless',80.00),(1143,'Frozen Fillet',40.00),(1144,'4oz Translucent',10.00),(1145,'Sorrano',104.00),(1146,'Fresh',42.00),(1147,'Tenderlion  Center Cut',92.00),(1148,'Salsa',94.00),(1149,'Jaboulet Cotes Du Rhone',28.00),(1150,'Bay Leaf Ground',14.00),(1151,'Cranberry  341 Ml',42.00),(1152,'Electric Blue',50.00),(1153,'Fat',95.00),(1154,'Fresh',82.00),(1155,'Blue',68.00),(1156,'Red Currant Jelly',10.00),(1157,'Black Bean  Preserved',9.00),(1158,'Fine',21.00),(1159,'Loin  Center Cut',82.00),(1160,'Campbellschix Stew',5.00),(1161,'Labatt Blue',35.00),(1162,'Cookie Trail Mix',12.00),(1163,'Frozen',103.00),(1164,'Frozen',3.00),(1165,'Detalini  White  Fresh',9.00),(1166,'Salmon',19.00),(1167,'Baileys',22.00),(1168,'Coffee Swiss Choc Almond',70.00),(1169,'Red Bell',46.00),(1170,'12in Rnd Blk',100.00),(1171,'Harrow Estates  Vidal',103.00),(1172,'Cookies Almond Hazelnut',64.00),(1173,'Green Scrubbie Pad H.duty',78.00),(1174,'Saddles',25.00),(1175,'Red  Dry',5.00),(1176,'Raspberry',22.00),(1177,'Soup Campbells Split Pea And Ham',26.00),(1178,'Fillets',90.00),(1179,'Stoneliegh Sauvignon',81.00),(1180,'Chorizo',48.00),(1181,'Jalapeno',34.00),(1182,'Dried',71.00),(1183,'Mince Meat',36.00),(1184,'Cooked Bayonne Tinned',105.00),(1185,'Apple Large',54.00),(1186,'Mango',81.00),(1187,'Unsweetened',37.00),(1188,'Bacardi Raspberry',9.00),(1189,'Primerba  Paste',21.00),(1190,'Glycerine',107.00),(1191,'Lamb Shoulder Boneless Nz',83.00),(1192,'355ml',67.00),(1193,'Loin  Bone',40.00),(1194,'Chicken Wings',15.00),(1195,'24 Foot',35.00),(1196,'Chocolate Marble Tea',82.00),(1197,'Bande Of Fruit',82.00),(1198,'Greek Salad',81.00),(1199,'Coffee Cup 12oz 5342cd',54.00),(1200,'Racks  Frenched',27.00),(1201,'Phillips',72.00),(1202,'Ban Dream Zero',30.00),(1203,'Propel Sport',33.00),(1204,'Absolut Citron',47.00),(1205,'Fine',90.00),(1206,'Cheese Tortellini',49.00),(1207,'Savoy',105.00),(1208,'10 Grain Parisian',28.00),(1209,'Plaintain',54.00),(1210,'Chardonnay Mondavi',7.00),(1211,'Strawberry',27.00),(1212,'Sage Derby',42.00),(1213,'Soup Base  Bouillon',1.00),(1214,'Ground',79.00),(1215,'Pie Shells 10',18.00),(1216,'Dover  Whole  Fresh',102.00),(1217,'Whole  Frozen',103.00),(1218,'Chenin Blanc K.w.v.',21.00),(1219,'Wine  Plastic  Clear 5 Oz',60.00),(1220,'Bread Foccacia Whole',64.00),(1221,'Baron De Rothschild',34.00),(1222,'600ml',87.00),(1223,'Yukon Gold  80 Ct',68.00),(1224,'2% 250 Ml',28.00),(1225,'White Chocolate',15.00),(1226,'Bleach',44.00),(1227,'Soya  Light',60.00),(1228,'Skim',109.00),(1229,'Absolut Citron',26.00),(1230,'Striploin',66.00),(1231,'Mint',77.00),(1232,'Olive Dinner Roll',76.00),(1233,'Orecchiette',90.00),(1234,'Transfer Sheets',42.00),(1235,'Cranberry Foccacia',73.00),(1236,'Prepared',104.00),(1237,'Braggs',34.00),(1238,'Nantuket Peach Orange',73.00),(1239,'Cookies Oatmeal Raisin',11.00),(1240,'Sushi Flat Iron Steak',98.00),(1241,'Foie Gras',60.00),(1242,'Earl Grey',16.00),(1243,'Pita',19.00),(1244,'Ecolab Crystal Fusion',61.00),(1245,'Solid Fusion',50.00),(1246,'Large',64.00),(1247,'Lemon Grass',106.00),(1248,'Mini Chocolate',84.00),(1249,'Chocolate',22.00),(1250,'Bande Of Fruit',71.00),(1251,'Brie danish',34.00),(1252,'Mix',8.00),(1253,'Portebello',48.00),(1254,'Higashimaru Usukuchi Soy',56.00),(1255,'Hardys Bankside Shiraz',32.00),(1256,'Cognac',88.00),(1257,'Apple Cider',71.00),(1258,'Iced Tea Peach',29.00),(1259,'Toku Katsuo',53.00),(1260,'Lid Coffee Cup 8oz Blk',98.00),(1261,'Cookie Choc',16.00),(1262,'Passion Fruit',63.00),(1263,'Back Ribs',48.00),(1264,'Paprika  Spanish',106.00),(1265,'Flexible Neon',93.00),(1266,'Breast',91.00),(1267,'Chef Hat 20cm',32.00),(1268,'Green Masala',57.00),(1269,'Pistoles  White',7.00),(1270,'White  French Cross',88.00),(1271,'Cherry',110.00),(1272,'Yoghurt Tubes',72.00),(1273,'Delicious  Red',72.00),(1274,'Sauza Silver',35.00),(1275,'0,01',57.00),(1276,'Lemon',10.00),(1277,'Plus  Orange',77.00),(1278,'Chorizo',98.00),(1279,'Thick Noodles',37.00),(1280,'Half Size Shallow',43.00),(1281,'Porcini  Dry',35.00),(1282,'Grilled Salmon With Bbq',75.00),(1283,'Bread Ww Cluster',8.00),(1284,'Carmenere Casillero Del',105.00),(1285,'Cream Of Potato / Leek',56.00),(1286,'Frthy Coffee Crisp',25.00),(1287,'Outside  Round',22.00),(1288,'Rib Roast  Cap On',49.00),(1289,'Frozen',27.00),(1290,'Energy Drink Bawls',5.00),(1291,'Cheese Cloth',12.00),(1292,'Mcguinness',109.00),(1293,'Morning Glory',10.00),(1294,'Blueberries',11.00),(1295,'Pecan Butter Squares',73.00),(1296,'Wiberg Super Cure',21.00),(1297,'Walkers Special Old Whiskey',56.00),(1298,'Mix',100.00),(1299,'Cheese Bites',86.00),(1300,'Water',16.00),(1301,'Lemon',63.00),(1302,'Fresh',101.00),(1303,'Shrimp Puff',86.00),(1304,'Brights  Dry',72.00),(1305,'Mini Greens  Whole',63.00),(1306,'V8 Pet',27.00),(1307,'Buckwheat  Organic',98.00),(1308,'Tomato',43.00),(1309,'Kidney  Red Dry',51.00),(1310,'Hp',98.00),(1311,'Fortune',1.00),(1312,'Corn Harvest',93.00),(1313,'Pearl',69.00),(1314,'Baking Soda',55.00),(1315,'Cotton Wet Mop 16 Oz',86.00),(1316,'Lettuce Romaine Chopped',42.00),(1317,'Canned',64.00),(1318,'Fillets',37.00),(1319,'Fine',59.00),(1320,'Nantucket Orange Juice',32.00),(1321,'White Paper',32.00),(1322,'Monin  Irish Cream',5.00),(1323,'Cool Blue Raspberry',70.00),(1324,'Chickpea',37.00),(1325,'600ml',97.00),(1326,'Assorted Rolls',79.00),(1327,'Lemon  460 Ml',32.00),(1328,'Fruli',65.00),(1329,'29 Foot',18.00),(1330,'Gilbeys London  Dry',107.00),(1331,'Nuckle',63.00),(1332,'Raspberry',95.00),(1333,'Spartan',38.00),(1334,'Black Currant',27.00),(1335,'Cranberry Foccacia',65.00),(1336,'Goldtouch Disposable',94.00),(1337,'Black Bean  Canned',9.00),(1338,'Atlantic  Skin On',40.00),(1339,'13 Inch',36.00),(1340,'Alfredo',107.00),(1341,'Anchovy Fillets',58.00),(1342,'Leg  Boneless',101.00),(1343,'Guy Sage Touraine',23.00),(1344,'Leaves',45.00),(1345,'Skim',87.00),(1346,'Honey',29.00),(1347,'Peas Snow',14.00),(1348,'Loin  Boneless',48.00),(1349,'Blackberry  20 Ml Jar',24.00),(1350,'Fresh',91.00),(1351,'Strawberry',58.00),(1352,'Custard',23.00),(1353,'Apricots Fresh',51.00),(1354,'Radish',18.00),(1355,'Roll  Soft White Round',67.00),(1356,'Comb',11.00),(1357,'Wings  Tip Off',42.00),(1358,'Lemon',58.00),(1359,'Baby  Boiled',49.00),(1360,'White  Unsliced',97.00),(1361,'Blackberry',31.00),(1362,'Energy Drink',90.00),(1363,'Corn',11.00),(1364,'Guiness',55.00),(1365,'Chips Potato Salt Vinegar 43g',59.00),(1366,'Solid Fusion',43.00),(1367,'Campbells  Lentil',88.00),(1368,'Shank  Pieces',102.00),(1369,'Ham Hocks',88.00),(1370,'Foam  Square 4',25.00),(1371,'Ched Chs Presliced',12.00),(1372,'Clear',99.00),(1373,'Bouchard La Vignee Pinot',63.00),(1374,'Bar Energy Chocchip',82.00),(1375,'Mango Chevre',2.00),(1376,'Five Alive Citrus',51.00),(1377,'Sliced',80.00),(1378,'Camembert',70.00),(1379,'Red  Marechal Foch',29.00),(1380,'Frozen',10.00),(1381,'Primerba  Paste',48.00),(1382,'Seeds',16.00),(1383,'Dungeness  Whole  live',100.00),(1384,'Earl Grey',102.00),(1385,'Cotes Du Rhone',65.00),(1386,'Green Tea Refresher',104.00),(1387,'English Muffin',95.00),(1388,'Red  Pinot Noir  Chateau',94.00),(1389,'Green',24.00),(1390,'Orange  341 Ml',58.00),(1391,'Napkin Colour',51.00),(1392,'White Fish',105.00),(1393,'Muffin Orange Individual',17.00),(1394,'Brisket  Provimi bnls',24.00),(1395,'Carrot',10.00),(1396,'Manchego  Spanish',58.00),(1397,'Creemore',46.00),(1398,'Le Cru Du Clocher',73.00),(1399,'Jagermeister',21.00),(1400,'Mikes Hard Lemonade',85.00),(1401,'Cornflakes',18.00),(1402,'Hickory Smoke  Liquid',104.00),(1403,'Black Forest',100.00),(1404,'Sleemans Honey Brown',83.00),(1405,'Rum',94.00),(1406,'Insides Provini',105.00),(1407,'White Cab Sauv.on',44.00),(1408,'Large',100.00),(1409,'Corn Syrup',45.00),(1410,'Backfat',90.00),(1411,'Paper Towel Touchless',85.00),(1412,'Merlot Vina Carmen',6.00),(1413,'Magnotta  White',22.00),(1414,'Baked Scones',27.00),(1415,'Cantaloupe',50.00),(1416,'Fresh',100.00),(1417,'Backfat',108.00),(1418,'Primerba  Paste',21.00),(1419,'Bernaise  Mix',107.00),(1420,'Sproutsmustard Cress',91.00),(1421,'Corn  Fine',67.00),(1422,'Wine',64.00),(1423,'Barolo Fontanafredda',49.00),(1424,'Shiraz Wolf Blass Premium',40.00),(1425,'Coffee Cup 8oz 5338cd',95.00),(1426,'Boo',72.00),(1427,'Dark',105.00),(1428,'Fresh',46.00),(1429,'Genova',102.00),(1430,'Comte',108.00),(1431,'Cream Of Broccoli',7.00),(1432,'Green',77.00),(1433,'Zinfandel California 2002',100.00),(1434,'Feathers',18.00),(1435,'Pomello',58.00),(1436,'Olive Bertolli',84.00),(1437,'Grilled Veg Sandwiches',83.00),(1438,'Aji Mirin',18.00),(1439,'Spartan',23.00),(1440,'Blood',16.00),(1441,'Celery Root',12.00),(1442,'Octopus',65.00),(1443,'Mangoes',75.00),(1444,'Macadamia',74.00),(1445,'Raspberry',75.00),(1446,'Muffin Hinge 117n',85.00),(1447,'Lobster Phyllo Roll',100.00),(1448,'Blue Nun Qualitatswein',50.00),(1449,'Sour Sticks With Onion',31.00),(1450,'10  Paper',35.00),(1451,'Plasticforkblack',94.00),(1452,'Sheep Milk',11.00),(1453,'Corn',66.00),(1454,'Orange  341 Ml',51.00),(1455,'Gorgonzola',52.00),(1456,'Bande Of Fruit',67.00),(1457,'Linguini  Dry',110.00),(1458,'Pizza Pizza Dough',59.00),(1459,'Teff',44.00),(1460,'Power Fusion',29.00),(1461,'Fillets',49.00),(1462,'Camerons Auburn',25.00),(1463,'Lou Black Shiraz',21.00),(1464,'Genova',62.00),(1465,'Pullman  Sliced',92.00),(1466,'Striploin Aa',89.00),(1467,'Tarragon Chicken',105.00),(1468,'Orange Roughy 4/6 Oz',100.00),(1469,'Focaccia Quarter',32.00),(1470,'Silicone Paper 16.5x24',19.00),(1471,'Kwv Chenin Blanc South',13.00),(1472,'Chianti Classico Riserva',72.00),(1473,'Mini Chocolate',30.00),(1474,'Snapple Raspberry Tea',26.00),(1475,'Filling',43.00),(1476,'Wild',10.00),(1477,'Valancey',106.00),(1478,'Potmums',65.00),(1479,'White  Ej',92.00),(1480,'Chicken And Wild Rice',67.00),(1481,'Escargot Puff',84.00),(1482,'Black Currants',105.00),(1483,'Mayonnaise',90.00),(1484,'Leg  Diced',98.00),(1485,'29 Foot',95.00),(1486,'Red',93.00),(1487,'Asian',73.00),(1488,'Alicanca Vinho Verde',10.00),(1489,'Towel Multifold',5.00),(1490,'Base Broth Chix',107.00),(1491,'Tail 6 Oz',86.00),(1492,'Beef Ground Medium',12.00),(1493,'Mcguinness',65.00),(1494,'Cheese Tortellini',44.00),(1495,'Tonic',76.00),(1496,'Cheese Cloth',107.00),(1497,'Clear  300 Lb For Carving',7.00),(1498,'Table Cloth 120 Round White',106.00),(1499,'Pain Au Liat X12',99.00),(1500,'Fuji Apples',75.00),(1501,'Banana Muffin',50.00),(1502,'Tiger 21/25',39.00),(1503,'10 Lb',14.00),(1504,'Corona',108.00),(1505,'Bacon Cooked Slcd',85.00),(1506,'Crumb',13.00),(1507,'Oreo Sandwich',33.00),(1508,'Cheddar  Mild',2.00),(1509,'Godiva White Chocolate',97.00),(1510,'Lemon  Fresh',40.00),(1511,'Banana Turning',89.00),(1512,'Ice Tea  Diet',10.00),(1513,'Placido Pinot Grigo',18.00),(1514,'Bay Leaf Fresh',40.00),(1515,'Lidsoupcont Rp12dn',30.00),(1516,'Wasabi Paste',82.00),(1517,'Juice Clear 5oz 55005',100.00),(1518,'Campbells  Creamy',70.00),(1519,'White  Unsliced',27.00),(1520,'Baby Pea Tendrils',63.00),(1521,'French Vanilla Frothy',77.00),(1522,'Wildberry',105.00),(1523,'Clavet Saint Emilion',98.00),(1524,'English Muffin',33.00),(1525,'Short Ribs',90.00),(1526,'Cambozola',15.00),(1527,'Wasabi Paste',109.00),(1528,'Morning Glory',91.00),(1529,'Spaghetti Squash',7.00),(1530,'Pan Grease',68.00),(1531,'Beringer Founders Estate',76.00),(1532,'Beef  White',40.00),(1533,'Parasol Pick Stir Stick',23.00),(1534,'Loin',25.00),(1535,'Red Pearl',68.00),(1536,'Jerusalem',70.00),(1537,'Tabasco Sauce  2 Oz',8.00),(1538,'Corn Shoots',17.00),(1539,'Black Bean  Preserved',13.00),(1540,'Brights  Dry',94.00),(1541,'Red  Harrow Estates  Cab',34.00),(1542,'Cheese Baked Scones',61.00),(1543,'225g',21.00),(1544,'Pecan  Halves',97.00),(1545,'White',32.00),(1546,'Mace Ground',66.00),(1547,'Ban Dream Zero',94.00),(1548,'Orange 1.89l',6.00),(1549,'Scallop  White',99.00),(1550,'Fireball Whisky',64.00),(1551,'Coconut  Malibu',49.00),(1552,'Smoked Tongue',20.00),(1553,'Leg  Diced',73.00),(1554,'Roma',76.00),(1555,'Golden  Lyles',7.00),(1556,'Assorted Rolls',24.00),(1557,'Browning Caramel Glace',60.00),(1558,'Chocolate Marble Tea',58.00),(1559,'Breast  Boneless Sk On',1.00),(1560,'Wheat Baguette',42.00),(1561,'Vue Containers',66.00),(1562,'Pernod',71.00),(1563,'Vacuum Bags 12x16',16.00),(1564,'Almond  Blanched  Whole',43.00),(1565,'Wax',107.00),(1566,'Ground',63.00),(1567,'Marble',109.00),(1568,'Orange Roughy 4/6 Oz',18.00),(1569,'Kellogs Raisan Bran Bars',58.00),(1570,'Kolrabi',45.00),(1571,'Camerons Auburn',53.00),(1572,'Kimel Stick Poly',58.00),(1573,'Sherry Dry Sack  William',85.00),(1574,'Cassis',43.00),(1575,'Fish',22.00),(1576,'Campbells  Lentil',72.00),(1577,'Bresaola',106.00),(1578,'Prune',32.00),(1579,'Fresh',43.00),(1580,'Cream Of Broccoli  Dry',16.00),(1581,'Unsalted',84.00),(1582,'Cooked  Corned',92.00),(1583,'Kalamata',86.00),(1584,'Instant Coffee',34.00),(1585,'Butter Sweet',50.00),(1586,'Strawberry',95.00),(1587,'Garam Masala Powder',54.00),(1588,'Verve',77.00),(1589,'Kumquat',14.00),(1590,'Prem Select Charddonany',13.00),(1591,'Pearl',35.00),(1592,'Ground',82.00),(1593,'Sweet And Salty Chocolate',89.00),(1594,'Trio',48.00),(1595,'Filling',78.00),(1596,'Chicken Curried',45.00),(1597,'Pina Colada  355 Ml',57.00),(1598,'Bouchard La Vignee Pinot',93.00),(1599,'White Meat  No Tender',11.00),(1600,'Blackcherry',28.00),(1601,'Englishbay Oatmeal',71.00),(1602,'Soup Campbells Split Pea And Ham',8.00),(1603,'Areo Chocolate',59.00),(1604,'Creme De Menthe Green',28.00),(1605,'Decaf Lipton',21.00),(1606,'Fresh',47.00),(1607,'Hagen Daz',15.00),(1608,'Canned',30.00),(1609,'Irish Whiskey',10.00),(1610,'Fresh',20.00),(1611,'Sockeye Raw',57.00),(1612,'Sunflower',44.00),(1613,'Eel Fresh',20.00),(1614,'Lime',36.00),(1615,'Monin  Swiss Choclate',52.00),(1616,'Frozen',98.00),(1617,'Strong Pizza',77.00),(1618,'Frozen',53.00),(1619,'Pablano',24.00),(1620,'Ecolab Silver Fusion',90.00),(1621,'Munchies Honey Sweet Trail Mix',62.00),(1622,'Cider',70.00),(1623,'Casablanca Valley',32.00),(1624,'Raisin Bran',30.00),(1625,'Squid Ink',17.00),(1626,'Envelopes',47.00),(1627,'Dehydrated Kelp Kombo',48.00),(1628,'16/20  Iqf  Shell On',108.00),(1629,'Sausage Casing',65.00),(1630,'Yams',73.00),(1631,'Goat With Herbs',56.00),(1632,'Sesame',94.00),(1633,'Strawberry',56.00),(1634,'White Epi Baguette',39.00),(1635,'Stilton',81.00),(1636,'Striploin',74.00),(1637,'Instant Coffee',18.00),(1638,'Pita',80.00),(1639,'Triangle White',77.00),(1640,'Peeled Italian Canned',63.00),(1641,'Wildberry',43.00),(1642,'Milk',103.00),(1643,'Roses',101.00),(1644,'Ground',89.00),(1645,'Eggplant Italian',63.00),(1646,'Whole  Frozen',67.00),(1647,'Cheese Baked Scones',62.00),(1648,'Eye Of Round',54.00),(1649,'Romaine',78.00),(1650,'Strawbrasp Peac',56.00),(1651,'Hot Dog Buns',34.00),(1652,'Filo Dough',100.00),(1653,'Shitake  Fresh',22.00),(1654,'Wooden Mop Handle',56.00),(1655,'Lou Black Shiraz',102.00),(1656,'Table Cloth 53x69 White',100.00),(1657,'Cheddarsliced',106.00),(1658,'Dulce De Leche',39.00),(1659,'Jasmine Sented',96.00),(1660,'Heavy Duty Dust Pan',8.00),(1661,'Shitake  Dry',9.00),(1662,'Knorr  Classic Can. Chili',49.00),(1663,'Kiwi Gold Zespri',5.00),(1664,'Montecillo Rioja Crianza',43.00),(1665,'Rambutan',45.00),(1666,'Mini Raspberry',98.00),(1667,'Zonnebloem Pinotage',11.00),(1668,'Rack',9.00),(1669,'Italian',99.00),(1670,'Whmis Spray Bottle Graduated',93.00),(1671,'Chicken Wings',107.00),(1672,'Parmesan Grated',108.00),(1673,'Creme De Cacao White',61.00),(1674,'Onions Granulated',6.00),(1675,'All Colours',31.00),(1676,'Knobless  White',67.00),(1677,'White  Canned',14.00),(1678,'Rum',42.00),(1679,'Inside Round',82.00),(1680,'3.5oz  Foam',78.00),(1681,'Absolut Citron',30.00),(1682,'Magnotta',51.00),(1683,'Vanilla artificial',78.00),(1684,'Chicken Giblets',34.00),(1685,'Red  Mouton Cadet',75.00),(1686,'Macintosh',77.00),(1687,'Paste / Cream',109.00),(1688,'Campbells  Butternut',36.00),(1689,'Taleggio D.o.p.',80.00),(1690,'Neutral',4.00),(1691,'Shells  Medium  Dry',68.00),(1692,'Cream Of Broccoli  Dry',65.00),(1693,'Shredded  Sweet',54.00),(1694,'Chocolate Fudge',92.00),(1695,'Garam Masala Powder',33.00),(1696,'Ruby Red',57.00),(1697,'Cambozola',30.00),(1698,'Wieners',64.00),(1699,'Soda / Saltins',3.00),(1700,'Seed',99.00),(1701,'Toothpick Frilled',7.00),(1702,'Prawn',15.00),(1703,'Clamato  341 Ml',62.00),(1704,'Table Cloth 62x114 Colour',8.00),(1705,'Tomatoes',3.00),(1706,'Garlic Powder',77.00),(1707,'Figs',28.00),(1708,'Thigh  Bone In',50.00),(1709,'Table Cloth 81x81 Colour',15.00),(1710,'16/20  Peeled Deviened',60.00),(1711,'Pork Casing',30.00),(1712,'Teff',25.00),(1713,'Whole  Fresh',79.00),(1714,'Bought',26.00),(1715,'In Shell',105.00),(1716,'Filling',10.00),(1717,'Penne  Lisce  Dry',42.00),(1718,'Huck Towels White',104.00),(1719,'Packum',81.00),(1720,'Table Cloth 144x90 White',57.00),(1721,'Pinot Grigio Collavini',7.00),(1722,'Monin',43.00),(1723,'Meat',57.00),(1724,'Teff',16.00),(1725,'Milk Powder',34.00),(1726,'Cheese Bites',33.00),(1727,'Assorted Sandwich',4.00),(1728,'Pickled',67.00),(1729,'Green  Dry',24.00),(1730,'White  Unsliced',96.00),(1731,'Cinnamon Rolls',16.00),(1732,'Durian Fruit',3.00),(1733,'Salted',38.00),(1734,'Medallion',94.00),(1735,'Banana Nut Individual',88.00),(1736,'Hazelnut',6.00),(1737,'Raisin Bran',109.00),(1738,'White  Ground',20.00),(1739,'Ruffino Chianti',13.00),(1740,'White  Whole',97.00),(1741,'Osso Bucco',39.00),(1742,'Dehydrated Kelp Kombo',59.00),(1743,'Liver',100.00),(1744,'Pecan Butter Squares',45.00),(1745,'Chafing Dish Fuel',97.00),(1746,'Ezy Change Mophandle',74.00),(1747,'Gooseberry',107.00),(1748,'Dungeness  Whole  live',37.00),(1749,'Pomegranates',100.00),(1750,'Shichimi Togarashi Peppeers',50.00),(1751,'Le Cheve Noir',7.00),(1752,'Watermelon  Seedless',40.00),(1753,'Leg',28.00),(1754,'Trippleberry Muffin',54.00),(1755,'Pink',85.00),(1756,'Brown Paper Mini Cups',40.00),(1757,'Rolled Oats',47.00),(1758,'Jamaican',25.00),(1759,'Bar Nature Valley',64.00),(1760,'Chardonnay South',31.00),(1761,'Haggis',51.00),(1762,'Burger Veggie',20.00),(1763,'Celery',88.00),(1764,'Red Thai',30.00),(1765,'Cider',20.00),(1766,'On The Cob',89.00),(1767,'Hazelnut Cream',92.00),(1768,'Maipo Valle Cabernet',15.00),(1769,'Clavet Saint Emilion',53.00),(1770,'100 / 200 Cold Water',16.00),(1771,'Magnotta',39.00),(1772,'Chicken Cordon Bleu',50.00),(1773,'Amaretto',57.00),(1774,'Paprika',32.00),(1775,'Cognac',53.00),(1776,'Tapenade',99.00),(1777,'Italian Wedding',59.00),(1778,'Life Savers',102.00),(1779,'Stainless Steel Cleaner Vision',23.00),(1780,'Campbells  Spinach Crm',48.00),(1781,'Latex Rubber Gloves Size 9',48.00),(1782,'Sherry',86.00),(1783,'Sping Loaded Cup Dispenser',26.00),(1784,'Cocktale',38.00),(1785,'Black Cherry Lemonade',100.00),(1786,'Bay Leaf Fresh',14.00),(1787,'Chicken  White',35.00),(1788,'Thousand Island',72.00),(1789,'Moosehead',15.00),(1790,'Regular',12.00),(1791,'Orange Roughy 4/6 Oz',43.00),(1792,'Oats Large Flake',43.00),(1793,'Fillets',22.00),(1794,'Campbells',92.00),(1795,'Spartan',59.00),(1796,'Baron De Rothschild',15.00),(1797,'Dome Lid Clear P92008h',106.00),(1798,'Cantonese',63.00),(1799,'Bones',46.00),(1800,'On The Cob',21.00),(1801,'Strawberry Lemonade',61.00),(1802,'Peeled',7.00),(1803,'Light',22.00),(1804,'Diced',49.00),(1805,'Milk  Callets',82.00),(1806,'Cheddar  Old White',94.00),(1807,'Seafood Assortment',21.00),(1808,'Brown  Individual',25.00),(1809,'Initation Crab Meat',18.00),(1810,'8oz Coffee Perforated',90.00),(1811,'Olive  Extra Virgin',32.00),(1812,'Finger Cots',2.00),(1813,'Outside  Round',95.00),(1814,'Smoked  Bone',49.00),(1815,'Thermometer Digital',44.00),(1816,'Parasol Pick Stir Stick',36.00),(1817,'Plastic Wrap',29.00),(1818,'Triangle White',16.00),(1819,'Foam  Square 4',100.00),(1820,'Dried',5.00),(1821,'Lemon',108.00),(1822,'Amber',99.00),(1823,'Monin',29.00),(1824,'Pita',101.00),(1825,'4oz Translucent',93.00),(1826,'Hickory Smoke  Liquid',45.00),(1827,'Camerons Auburn',70.00),(1828,'Bar Nature Valley',25.00),(1829,'Rock  Course',75.00),(1830,'Black Cherry',86.00),(1831,'Bresaola',2.00),(1832,'Fennel',15.00),(1833,'Penne  Rigate  Dry',108.00),(1834,'Iqf',23.00),(1835,'Sawmill Creek Autumn',72.00),(1836,'Beef Dry Aged Tenderloin Aaa',37.00),(1837,'Fortune',11.00),(1838,'Foam Dixie 12 Oz',46.00),(1839,'Shallots',35.00),(1840,'Ground',29.00),(1841,'Red  Colio Cabernet',14.00),(1842,'Bacardi Mojito',28.00),(1843,'Ocean Spray Cranberry',65.00),(1844,'Cubes',14.00),(1845,'Smoked Paprika',13.00),(1846,'Chateauneuf Du Pape',73.00),(1847,'Pepper',104.00),(1848,'Table Cloth 62x120 White',31.00),(1849,'Dark Rye',24.00),(1850,'Skim',53.00),(1851,'Soup Campbells Beef With Veg',107.00),(1852,'Semolina',44.00),(1853,'Fish 25 Ozf Bottle',11.00),(1854,'Lid Coffee Cup 8oz Blk',63.00),(1855,'Table Cloth 53x69 White',109.00),(1856,'Yokaline',108.00),(1857,'Brussel',76.00),(1858,'211n',78.00),(1859,'Berry Brulee',40.00),(1860,'Toku Katsuo',107.00),(1861,'Mocha',80.00),(1862,'Strawberry',62.00),(1863,'Sour Puss Sour Apple',9.00),(1864,'Upper Canada Light',54.00),(1865,'Whole  Fresh',12.00),(1866,'Chablis J Moreau Et Fils',79.00),(1867,'Prime Rib Aaa',81.00),(1868,'Whmis Spray Bottle Graduated',42.00),(1869,'Peppercorn',65.00),(1870,'Lid Coffeecup 12oz D9542b',80.00),(1871,'Soupfoamcont12oz 112con',99.00),(1872,'Primerba  Paste',45.00),(1873,'Mango',95.00),(1874,'Insides  Grains',72.00),(1875,'White Baguette',107.00),(1876,'Buttons',75.00),(1877,'Bones',96.00),(1878,'Soup Bowl Clear 8oz92008',64.00),(1879,'Frisee',14.00),(1880,'True North Strong Ale',80.00),(1881,'Rose  Freixenet',17.00),(1882,'Vanilla',69.00),(1883,'Striped Red',47.00),(1884,'Nappa',65.00),(1885,'Vue Containers',36.00),(1886,'Lasagna  Dry',53.00),(1887,'Italian',77.00),(1888,'Saint Emilion Calvet',88.00),(1889,'Oneshot Automatic Soap System',23.00),(1890,'Fresh',82.00),(1891,'Bread Fig And Almond',97.00),(1892,'Lasagne  Fresh',53.00),(1893,'Madras',42.00),(1894,'Asiago',48.00),(1895,'Striploin',30.00),(1896,'Frozen',71.00),(1897,'Whole',104.00),(1898,'Mixed',5.00),(1899,'Fudge Bars',49.00),(1900,'Taro Root',90.00),(1901,'Cotton  24 Oz',42.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-29  9:39:28
