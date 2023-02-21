-- create database g62;
-- use g62;     

create table Role (
id int not null PRIMARY KEY auto_increment,
name varchar(255)
);
create table Majors(
id int not null PRIMARY KEY auto_increment,
name varchar(255),
room varchar(20)
);
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
  gmail varchar(255),
  password varchar(255),
  foreign key (id_role) references Role(id),
   foreign key (id_majors) references Majors(id)
);

CREATE TABLE Schedule (
  id int not null PRIMARY KEY auto_increment,
  id_majors int,
  id_user int ,
  descrip nvarchar(500),
  Day date,
  Time time,
  foreign key (id_majors) references Majors(id),
  foreign key (id_user) references Users(id)
);
ALTER TABLE Schedule ADD status int;
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
ALTER TABLE Feedback ADD date date;
CREATE TABLE Examination (
  id int not null PRIMARY KEY auto_increment,
  Doctor_In_Charge int,
  id_user int ,
  Visit_Time datetime,
  Disease_Description varchar(255),
  Diagnose varchar(255),
  Conclusion varchar(255),
  Total_Test_Price float,
  status int
);


create table Stock (
id int not null PRIMARY KEY auto_increment,
description nvarchar(500),
id_exam int ,
foreign key (id_exam) references Examination(id)
);
CREATE TABLE Test (
  id int not null PRIMARY KEY auto_increment,
  Doctor_In_Charge int,
  Description varchar(255),
  Result varchar(255),
  Price float,
  id_exam int ,
foreign key (id_exam) references Examination(id)
);
CREATE TABLE Biochemistry_Test (
  id int not null PRIMARY KEY auto_increment,
  id_user int ,
  id_test int,
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
    foreign key (id_test) references Test(id),
  foreign key (id_user) references Users(id)
);

CREATE TABLE Blood_Test (
  id int not null PRIMARY KEY auto_increment,
  id_user int ,
  id_test int ,
  Red_Blood_Cell float,
  White_Blood_Cell float,
  Platelets float,
  Hemoglobin float,
  Hematocrit float,
  Mean_Corpuscular_Volume int,
    foreign key (id_test) references Test(id),
  foreign key (id_user) references Users(id)
);

CREATE TABLE Immunoass_Test (
  id int not null PRIMARY KEY auto_increment,
  id_test int ,
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
  foreign key (id_test) references Test(id),
  foreign key (id_user) references Users(id)
);

-- status 0 : chưa hoàn thành 
-- 1 : đã hoàn thành .
CREATE TABLE Record (
  id int not null PRIMARY KEY auto_increment,
  id_user int,
  id_exam int ,
  foreign key (id_user) references Users(id),
  foreign key (id_exam) references Examination(id)
);
CREATE TABLE Bill (
  id int not null PRIMARY KEY auto_increment,
  id_exam int,
  Final_Price float,
  Description varchar(255),
  foreign key (id_exam) references Examination(id)
);

