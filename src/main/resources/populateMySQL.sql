INSERT INTO `category` VALUES (NULL,'Car')
INSERT INTO `category` VALUES (NULL,'SUV')
INSERT INTO `category` VALUES (NULL,'Truck')
INSERT INTO `category` VALUES (NULL,'Van')
--
--
INSERT INTO `vehicleClass` VALUES (NULL,'Economy')
INSERT INTO `vehicleClass` VALUES (NULL,'Intermediate')
INSERT INTO `vehicleClass` VALUES (NULL,'Standard')
INSERT INTO `vehicleClass` VALUES (NULL,'Premium')
--
--
INSERT INTO `vehicle`(id,bags,capacity,description,price,specialFeatures,vehicleId,category_id,vehicleClass_id) VALUES (NULL,2,4,'Toyota Cambri',70,'Automatic, Air Conditioning, AM/FM Stereo and CD',101,1,1)
INSERT INTO `vehicle`(id,bags,capacity,description,price,specialFeatures,vehicleId,category_id,vehicleClass_id) VALUES (NULL,3,6,'TATA Sumo',120,'Cruise Control, Automatic, Air Conditioning',102,3,2)
INSERT INTO `vehicle`(id,bags,capacity,description,price,specialFeatures,vehicleId,category_id,vehicleClass_id) VALUES (NULL,2,4,'Mazda CS-5',100,'Cruise Control, Air Conditioning, AM/FM Stereo',103,2,4)


INSERT INTO `customer`(customerId,authority,city,country,state,streetName,zipCode,creditCardExpirationDate,creditCardNumber,creditcardType, enabled, password, customerEmail, customerPhone, dateOfBirth, driverLicenceNumber, driverLicenceNumberExpirationDate, driverLicenceUsingCountryOrState, firstName, lastName, middleName, title, username) VALUES(NULL, 'ROLE_ADMIN','Fairfield','US','IA','Main Street','52557','2016-12-12','1234123412341234','Master Card',1,'admin1','bpaans@gmail.com','6415559999','1990-01-01','123456','2017-01-01','USA','Bharat','Pandey','Nothing','Mr.','admin1')
INSERT INTO `customer`(customerId,authority,city,country,state,streetName,zipCode,creditCardExpirationDate,creditCardNumber,creditcardType, enabled, password, customerEmail, customerPhone, dateOfBirth, driverLicenceNumber, driverLicenceNumberExpirationDate, driverLicenceUsingCountryOrState, firstName, lastName, middleName, title, username) VALUES(NULL, 'ROLE_USER','Fairfield','US','IA','Main Street','52557','2016-12-12','1234123412341234','Master Card',1,'user1','bpaans@gmail.com','6415559999','1990-01-01','123456','2017-01-01','USA','Bharat','Pandey','Nothing','Mr.','user1')