
-- insert Type 
INSERT INTO `g62`.`Type` (`name`, `price`) VALUES ('Biochemistry Test', '500000');
INSERT INTO `g62`.`Type` (`name`, `price`) VALUES ('Blood Test', '450000');
INSERT INTO `g62`.`Type` (`name`, `price`) VALUES ('Immunoass Test', '550000');
INSERT INTO `g62`.`Type` (`name`, `price`) VALUES ('Medical examination fee', '100000');
-- insert Role

INSERT INTO `g62`.`Role` (`name`) VALUES ('Admin');
INSERT INTO `g62`.`Role` (`name`) VALUES ('Doctor');
INSERT INTO `g62`.`Role` (`name`) VALUES ('Reception');
INSERT INTO `g62`.`Role` (`name`) VALUES ('Customer');
-- insert Majors
INSERT INTO `g62`.`Majors` (`room`) VALUES ( 'R01');
INSERT INTO `g62`.`Majors` (`room`) VALUES ('R02');
INSERT INTO `g62`.`Majors` ( `room`) VALUES ('R03');
INSERT INTO `g62`.`Majors` ( `room`) VALUES ('Test');
-- insert doctor 
INSERT INTO `g62`.`Users` (`name`, `img`, `phone`, `Date_Of_Birth`, `Gender`, `Citizen_Id`, `Health_Id`, `Address`, `id_role`, `id_majors`, `isBlock`, `gmail`, `password`) VALUES ('Doctor Strange', 'd1.jpg', '3234324', '2002-10-20', '1', '1231231232', '45345345345', 'hn', '2', '1', '1', 'a@gmail.com', '2e678024cabebdfe17a5aeef0163fe6d');
INSERT INTO `g62`.`Users` (`name`, `img`, `phone`, `Date_Of_Birth`, `Gender`, `Citizen_Id`, `Health_Id`, `Address`, `id_role`, `id_majors`, `isBlock`, `gmail`, `password`) VALUES ('Doctor John', 'd2.jpg', '323545', '2001-10-10', '2', '242342', '4234234', 'hn', '2', '2', '1', 'a1@gmail.com', '2e678024cabebdfe17a5aeef0163fe6d');
INSERT INTO `g62`.`Users` (`name`, `img`, `phone`, `Date_Of_Birth`, `Gender`, `Citizen_Id`, `Health_Id`, `Address`, `id_role`, `id_majors`, `isBlock`, `gmail`, `password`) VALUES ('Doctor Fake', 'd3.jpg', '3454', '2000-11-19', '1', '234324', '42343', 'hn', '2', '3', '1', 'a2@gmail.com', '2e678024cabebdfe17a5aeef0163fe6d');
INSERT INTO `g62`.`Users` (`name`, `img`, `phone`, `Date_Of_Birth`, `Gender`, `Citizen_Id`, `Health_Id`, `Address`, `id_role`, `id_majors`, `isBlock`, `gmail`, `password`) VALUES ('Doctor Fake', 'd3.jpg', '3454', '2000-11-19', '1', '234324', '42343', 'hn', '2', '3', '1', 'd4@gmail.com', '2e678024cabebdfe17a5aeef0163fe6d');
-- insert Exam
INSERT INTO `g62`.`Examination` 
(`Doctor_In_Charge`, `id_user`, `id_bio`, `id_blood`, `id_immu`, `Visit_Time`,
 `Disease_Description`, `Diagnose`, `Conclusion`, `Total_Test_Price`, `status`) VALUES
 ('1', '8', '1', '1', '1', '2023-03-01 15:48:33', 'm', 'm', 'm', '2000000', '0');
