create database if not exists AirlineManagement;
use AirlineManagement;
drop table aircraft;
create table Aircraft (
Model_name char(50),
Capacity int,
Flying_Range int,
Manufacturer char(50),
Price int,
PRIMARY KEY (Model_name));
create table Flight(
Flight_ID char(20),
Source char(50),
Destination char(50),
Arrival_Time datetime,
Deaprture_Timme datetime,
Distance int,
Model_Name char(50),
Caterer_ID char(20),
primary key(Flight_ID) );
create table Crew(
Crew_ID int,
Name char(50),
Gender char(20),
Post char(50),
Hours_Worked_per_week int,
Salary int,
PRIMARY KEY (Crew_ID));
create table Assign(
Assignment_ID int,
Flight_ID char(50),
Crew_ID char(50),
PRIMARY KEY (Assignment_ID));
create table Ledger(
Ledger_ID int,
Flight_ID char(50),
Income int,
Cost int,
PRIMARY KEY (Ledger_ID));
create table Caterers(
Caterers_ID int,
Name char(50),
Capacity_per_flight int,
Cost_per_meal int,
PRIMARY KEY(Caterers_ID));
create table Aircraft_Instance(
Model_No int,
Model_Name char(50),
Economy_Class_Seats int,
Business_Class_Seats int,
First_Class_Seats int,
Date_Of_Commission date,
Insurance_Expiry_date date,
Last_Maintenance_Date date,
primary key(Model_No));
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Aircraft.txt'
INTO TABLE Aircraft
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;
select * from Aircraft;
INSERT INTO Aircraft Value ("Boeing 747", 416, 7240, "Boeing", 350000000);
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Caterers.txt'
INTO TABLE Caterers
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
select * from Caterers;
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Flight.txt'
INTO TABLE Flight
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
Drop table Aircraft_Instance;
create table Aircraft_Instance(
Model_No int,
Model_Name char(50),
Economy_Class_Seats int,
Business_Class_Seats int,
First_Class_Seats int,
Date_Of_Commission varchar(30),
Insurance_Expiry_date varchar(30),
Last_Maintenance_Date varchar(30),
primary key(Model_No));
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Aircraft_Instance.txt'
INTO TABLE Aircraft_Instance
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
select * from Aircraft_Instance;
drop table Flight;
create table Flight(
Flight_ID char(20),
Source char(50),
Destination char(50),
Arrival_Time varchar(50),
Departure_Timme varchar(50),
Distance int,
Model_Name char(50),
Caterer_ID char(20),
primary key(Flight_ID) );
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Flight.txt'
INTO TABLE Flight
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
select * from Flight;
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Flight.txt'
INTO TABLE Flight
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 30 LINES;
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Crew.txt'
INTO TABLE crew
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Assign.txt'
INTO TABLE assign
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'; 
select * from Flight;
drop table flight;
create table Flight(
Flight_ID char(20),
Source char(50),
Destination char(50),
Arrival_Time datetime,
Departure_Time datetime,
Model_No int,
Distance int,
Caterer_ID char(20),
primary key(Flight_ID) );
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Flight.txt'
INTO TABLE Flight
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
drop table Flight;
create table Flight(
Flight_ID char(20),
Source char(50),
Destination char(50),
Arrival_Time varchar(50),
Departure_Time varchar(50),
Model_No int,
Distance int,
Caterer_ID char(20),
primary key(Flight_ID) );
drop table crew;
create table Crew(
Crew_ID int,
Name char(50),
Gender char(20),
Post char(50),
Hours_Worked_per_week int,
Salary int,
Password int,
PRIMARY KEY (Crew_ID));
LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Crew.txt'
INTO TABLE crew
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';