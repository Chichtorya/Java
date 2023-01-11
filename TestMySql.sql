create database demo;
CREATE TABLE `User`.`Account` (
  `Id` varchar(255) PRIMARY KEY,
  `Gmail` varchar(255),
  `Password` varchar(255)
);
INSERT INTO `User`.`Account`
VALUES ("ABC123", "khanh", "12345678");

select*
From `User`.`Account`
Where Gmail = "khanh" and Password = "12345678"