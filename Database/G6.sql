CREATE TABLE `User_Profile` (
  `Id` int PRIMARY KEY,
  `name` varchar(255),
  `Phone_Number` varchar(255),
  `Date_Of_Birth` date,
  `Gender` ENUM ('Male', 'Female', 'Unknow'),
  `Role` ENUM ('Admin', 'Doctor', 'Reception', 'Other'),
  `Addr` varchar(255),
  `Gmail` varchar(255),
  `Password` varchar(255)
);

CREATE TABLE `Patien_Info` (
  `Id` int PRIMARY KEY,
  `name` varchar(255),
  `Citizen_Identity_Id` varchar(255),
  `Health_Insurance_Id` varchar(255),
  `Phone_Number` varchar(255),
  `Date_Of_Birth` date,
  `Gender` ENUM ('Male', 'Female', 'Unknow'),
  `Address` varchar(255)
);

CREATE TABLE `Medical_Record` (
  `Id` int PRIMARY KEY,
  `Patien_Id` int
);

CREATE TABLE `Medical_Examination` (
  `Id` int PRIMARY KEY,
  `Medical_Record_id` int,
  `Doctor_In_Charge` int,
  `Visit_Time` datetime,
  `Is_Test` boolean,
  `Disease_Description` varchar(255),
  `Diagnose` varchar(255),
  `Conclusion` varchar(255),
  `Total_Test_Price` double
);

CREATE TABLE `Medical_Test` (
  `Id` int PRIMARY KEY,
  `Medical_Examination_Id` int,
  `Type` ENUM ('Biochemistry', 'Immunoassay', 'Blood'),
  `Doctor_In_Charge` int,
  `Description` varchar(255),
  `Result` varchar(255),
  `Price` double
);

CREATE TABLE `Biochemistry_Test` (
  `Id` int PRIMARY KEY,
  `Medical_Test_Id` int,
  `Fasting` float,
  `PP` float,
  `Urea` float,
  `S_Creatinine` float,
  `Sodium` float,
  `Potassium` float,
  `Chloride` float,
  `Total_Calcium` float,
  `S_Calcium` float,
  `Uric_Acid` float,
  `Total_Bilirubin` float,
  `Alkaline_Phosphate` float,
  `Total_Protein` float,
  `Albumin` float,
  `Total_Cholesterol` float,
  `Triglyceride` float,
  `ADA` float
);

CREATE TABLE `Blood_Test` (
  `Id` int PRIMARY KEY,
  `Medical_Test_Id` int,
  `Red_Blood_Cell` double,
  `White_Blood_Cell` double,
  `Platelets` double,
  `Hemoglobin` float,
  `Hematocrit` float,
  `Mean_Corpuscular_Volume` int
);

CREATE TABLE `Immunoass_Test` (
  `Id` int PRIMARY KEY,
  `Medical_Test_Id` int,
  `Digoxin` float,
  `Estradiol` float,
  `Ferritin` float,
  `Folic_Acid` float,
  `Progesterone` float,
  `Prolactin` float,
  `Troponin_T` float,
  `Testosterone` float,
  `Total_PSA` float
);

CREATE TABLE `Bill_Info` (
  `Id` int PRIMARY KEY,
  `Medical_Examination_Id` int,
  `Final_Price` double,
  `Description` varchar(255)
);

CREATE TABLE `Schedule` (
  `Id` int PRIMARY KEY,
  `User_Id` int,
  `Day` ENUM ('Mon', 'Tue', 'Wed', 'Fri', 'Sat', 'Sun', 'Thu'),
  `Time` datetime,
  `Patien_Id` int
);

ALTER TABLE `Medical_Record` ADD FOREIGN KEY (`Patien_Id`) REFERENCES `Patien_Info` (`Id`);

ALTER TABLE `Medical_Examination` ADD FOREIGN KEY (`Medical_Record_id`) REFERENCES `Medical_Record` (`Id`);

ALTER TABLE `Medical_Examination` ADD FOREIGN KEY (`Doctor_In_Charge`) REFERENCES `User_Profile` (`Id`);

ALTER TABLE `Medical_Test` ADD FOREIGN KEY (`Medical_Examination_Id`) REFERENCES `Medical_Examination` (`Id`);

ALTER TABLE `Medical_Test` ADD FOREIGN KEY (`Doctor_In_Charge`) REFERENCES `User_Profile` (`Id`);

ALTER TABLE `Biochemistry_Test` ADD FOREIGN KEY (`Medical_Test_Id`) REFERENCES `Medical_Test` (`Id`);

ALTER TABLE `Blood_Test` ADD FOREIGN KEY (`Medical_Test_Id`) REFERENCES `Medical_Test` (`Id`);

ALTER TABLE `Immunoass_Test` ADD FOREIGN KEY (`Medical_Test_Id`) REFERENCES `Medical_Test` (`Id`);

ALTER TABLE `Bill_Info` ADD FOREIGN KEY (`Medical_Examination_Id`) REFERENCES `Medical_Examination` (`Id`);

ALTER TABLE `Schedule` ADD FOREIGN KEY (`User_Id`) REFERENCES `User_Profile` (`Id`);

ALTER TABLE `Schedule` ADD FOREIGN KEY (`Patien_Id`) REFERENCES `Patien_Info` (`Id`);
