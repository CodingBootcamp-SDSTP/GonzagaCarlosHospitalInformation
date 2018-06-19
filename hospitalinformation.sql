DROP TABLE IF EXISTS patient_medical_case;
DROP TABLE IF EXISTS medical_case;
DROP TABLE IF EXISTS patient_doctor;
DROP TABLE IF EXISTS attending_doctor;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS doctor_type;
DROP TABLE IF EXISTS confinement;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
	person_id INT NOT NULL AUTO_INCREMENT,
	lastname VARCHAR(40) NOT NULL,
	firstname VARCHAR(60) NOT NULL,
	name_extension VARCHAR(3),
	middlename VARCHAR(40),
	birthday DATE,
	sex ENUM('M', 'F'),
	PRIMARY KEY (person_id)
);

CREATE TABLE room (
	room_number INT NOT NULL,
	type ENUM('PRIVATE', 'WARD'),
	bed_capacity INT NOT NULL,
	number_of_occupied_beds INT NOT NULL,
	PRIMARY KEY (room_number)
);

CREATE TABLE confinement (
	confinement_id INT NOT NULL AUTO_INCREMENT,
	person_id INT NOT NULL,
	admission_date_time DATETIME NOT NULL,
	discharge_date_time DATETIME,
	room_number INT NOT NULL,
	PRIMARY KEY (confinement_id),
	FOREIGN KEY (person_id) REFERENCES person (person_id),
	FOREIGN KEY (room_number) REFERENCES room (room_number)
);

CREATE TABLE doctor_type (
	type_id INT NOT NULL AUTO_INCREMENT,
	description VARCHAR(40) NOT NULL,
	PRIMARY KEY (type_id)
);

CREATE TABLE doctor (
	license_number INT NOT NULL,
	person_id INT NOT NULL,
	type_id INT NOT NULL,
	PRIMARY KEY (license_number),
	FOREIGN KEY (person_id) REFERENCES person (person_id),
	FOREIGN KEY (type_id) REFERENCES doctor_type (type_id)
);

CREATE TABLE attending_doctor (
	confinement_id INT NOT NULL,
	license_number INT NOT NULL,
	PRIMARY KEY (confinement_id, license_number),
	FOREIGN KEY (confinement_id) REFERENCES confinement (confinement_id),
	FOREIGN KEY (license_number) REFERENCES doctor (license_number)
);

CREATE TABLE medical_case (
	medical_case_id INT AUTO_INCREMENT,
	code VARCHAR(6) NOT NULL,
	description VARCHAR(60) NOT NULL,
	PRIMARY KEY (medical_case_id),
	CONSTRAINT UC_medical_case UNIQUE (code)
);

CREATE TABLE patient_medical_case (
	confinement_id INT NOT NULL,
	medical_case_id INT NOT NULL,
	PRIMARY KEY (confinement_id, medical_case_id),
	FOREIGN KEY (confinement_id) REFERENCES confinement (confinement_id),
	FOREIGN KEY (medical_case_id) REFERENCES medical_case (medical_case_id)
);
