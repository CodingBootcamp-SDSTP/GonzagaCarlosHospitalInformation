CREATE TABLE IF NOT EXISTS person (
	person_id INT NOT NULL AUTO_INCREMENT,
	lastname VARCHAR(40) NOT NULL,
	firstname VARCHAR(60) NOT NULL,
	name_extension VARCHAR(3),
	middlename VARCHAR(40),
	birthday DATE,
	sex ENUM('M', 'F'),
	PRIMARY KEY (person_id)
);

CREATE TABLE IF NOT EXISTS room (
	room_number INT NOT NULL,
	type ENUM('PRIVATE', 'WARD'),
	bed_capacity INT NOT NULL,
	number_of_occupied_beds INT NOT NULL,
	PRIMARY KEY (room_number)
);

CREATE TABLE IF NOT EXISTS patient_confinement (
	confinement_id INT NOT NULL AUTO_INCREMENT,
	person_id INT NOT NULL,
	admission_date_time DATETIME NOT NULL,
	discharge_date_time DATETIME,
	room_number INT NOT NULL,
	PRIMARY KEY (confinement_id),
	FOREIGN KEY (person_id) REFERENCES person (person_id),
	FOREIGN KEY (room_number) REFERENCES room (room_number)
);

CREATE TABLE IF NOT EXISTS doctor_type (
	type_id INT NOT NULL AUTO_INCREMENT,
	description VARCHAR(40) NOT NULL,
	PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS doctor (
	license_number INT NOT NULL,
	doctor_id INT NOT NULL,
	type_id INT NOT NULL,
	PRIMARY KEY (license_number),
	FOREIGN KEY (doctor_id) REFERENCES person (person_id),
	FOREIGN KEY (type_id) REFERENCES doctor_type (type_id)
);

CREATE TABLE IF NOT EXISTS patient_doctor (
	confinement_id INT NOT NULL,
	doctor_id INT NOT NULL,
);

CREATE TABLE IF NOT EXISTS medical_case (
	medical_case_id INT AUTO_INCREMENT,
	medical_case_code VARCHAR(6) NOT NULL,
	description VARCHAR(60) NOT NULL,
	PRIMARY KEY (medical_case_id),
	CONSTRAINT UC_medical_case UNIQUE (medical_case_code)
);

CREATE TABLE IF NOT EXISTS patient_medical_case (
	confinement_id INT NOT NULL,
	medical_case_id INT NOT NULL,
	FOREIGN KEY (confinement_id) REFERENCES patient_confinement (confinement_id),
	FOREIGN KEY (medical_case_id) REFERENCES medical_case (medical_case_id)
);
