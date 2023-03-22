-- create database g62;
-- use g62;     
-- drop database g62;
create table Role (
id int not null PRIMARY KEY auto_increment,
name varchar(255)
);
create table Majors(
id int not null PRIMARY KEY auto_increment,
room varchar(20)
);
 -- ALTER TABLE Majors DROP COLUMN name;
-- Role : 1 là Admin
-- 2 là Doctor 
-- 3 là Reception
-- 4 là Customer 
-- isBlock : 1 là chưa block 
  -- 0 là đã block
-- Gender : 1 là Male 
-- 2 là Female 
	
CREATE TABLE Users (
  id int not null PRIMARY KEY auto_increment,
  name nvarchar(255),
  img varchar(255),
  phone varchar(20),
  Date_Of_Birth date,
  Gender int ,
  Citizen_Id varchar(25),
  Health_Id varchar(25),
  Address varchar(255),
  id_role int , 
  id_majors int,
  isBlock int , 
  salary float,
  gmail varchar(255),
  password varchar(255),
  foreign key (id_role) references Role(id),
   foreign key (id_majors) references Majors(id)
);

--  ALTER TABLE Users
-- DROP COLUMN salary;
-- ALTER TABLE Users ADD salary float;
-- status 0 là chưa làm
-- 1 là đang kiểm tra
-- 2 là đã hoàn thành 

create table Feedback (
id int not null PRIMARY KEY auto_increment,
id_user int ,
feedback nvarchar(2000),
date date,
foreign key (id_user) references Users(id)
);

-- ALTER TABLE Feedback ADD date date;
CREATE TABLE Examination (
  id int not null PRIMARY KEY auto_increment,
  Doctor_In_Charge int,
  id_user int ,
  id_bio int ,
  id_blood int ,
  id_immu int  ,
  Visit_Time datetime,
  Disease_Description varchar(255),
  Diagnose varchar(255),
  Conclusion varchar(255),
  Total_Test_Price float,
  status int
);
-- id_bio , id_blood , id_immu =0 la ko co , 1 la co
CREATE TABLE Prescription_Detail (
  id int NOT NULL AUTO_INCREMENT,
  Exam_id int NOT NULL,
  Drug_Name varchar(255) NOT NULL,
  Dosage varchar(255) NOT NULL,
  note varchar(255) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (Exam_id) REFERENCES Examination(id)
);
-- CREATE TABLE Test (
--   id int not null PRIMARY KEY auto_increment,
--   Doctor_In_Charge int,
--   Description varchar(255),
--   Result varchar(255),
--   Price float,
--   id_exam int ,
-- foreign key (id_exam) references Examination(id)
-- );
create table Type (
  id int not null PRIMARY KEY auto_increment,
name nvarchar(50),
price float
);
CREATE TABLE Schedule (
  id int not null PRIMARY KEY auto_increment,
  id_majors int,
  id_user int ,
  descrip nvarchar(500),
  Day datetime,
  id_exam int ,
  id_type int,
  status int,
    foreign key (id_type) references Type(id),
   foreign key (id_exam) references Examination(id),
  foreign key (id_majors) references Majors(id),
  foreign key (id_user) references Users(id)
);

-- alter table Schedule add status int ;
CREATE TABLE Biochemistry_Test (
  id int not null PRIMARY KEY auto_increment,
  id_user int ,
  id_exam int,
  Fasting float,
  PP float,
  Urea float,
  S_Creatinine float,
  Sodium float,
  Potassium float,
  Chloride float,
  Total_Calcium float,
  S_Calcium float,
  Uric_Acid float,
  Total_Bilirubin float,
  Alkaline_Phosphate float,
  Total_Protein float,
  Albumin float,
  Total_Cholesterol float,
  Triglyceride float,
  ADA float,
  result nvarchar(255),
  foreign key (id_exam) references Examination(id),
  foreign key (id_user) references Users(id)
);
-- alter table Immunoass_Test add result nvarchar(255)
CREATE TABLE Blood_Test (
  id int not null PRIMARY KEY auto_increment,
  id_user int ,
  id_exam int ,
  Red_Blood_Cell float,
  White_Blood_Cell float,
  Platelets float,
  Hemoglobin float,
  Hematocrit float,
  Mean_Corpuscular_Volume int,
  result nvarchar(255),
    foreign key (id_exam) references Examination(id),
  foreign key (id_user) references Users(id)
);

CREATE TABLE Immunoass_Test (
  id int not null PRIMARY KEY auto_increment,
  id_exam int ,
  id_user int ,
  Digoxin float,
  Estradiol float,
  Ferritin float,
  Folic_Acid float,
  Progesterone float,
  Prolactin float,
  Troponin_T float,
  Testosterone float,
  Total_PSA float,
  result nvarchar(255),
  foreign key (id_exam) references Examination(id),
  foreign key (id_user) references Users(id)
);

-- status 0 : chưa hoàn thành 
-- 1 : đã hoàn thành .
-- CREATE TABLE Record (
--   id int not null PRIMARY KEY auto_increment,
--   id_user int,
--   id_exam int ,
--   foreign key (id_user) references Users(id),
--   foreign key (id_exam) references Examination(id)
-- );
CREATE TABLE Bill (
  id int not null PRIMARY KEY auto_increment,
  id_user int ,
  id_exam int,
  totalPrice float,
  status int ,
  foreign key (id_user) references Users(id),
  foreign key (id_exam) references Examination(id)
  );
create table Bill_Order(
  id int not null PRIMARY KEY auto_increment,
  id_bill int,
  id_type int ,
  price float ,
  foreign key (id_bill) references Bill(id)
);

         
