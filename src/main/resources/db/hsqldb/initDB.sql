DROP TABLE users IF EXISTS;
DROP TABLE authorities IF EXISTS;
DROP TABLE user_authorities IF EXISTS;

CREATE TABLE IF NOT EXISTS users (
 	 id 				INTEGER IDENTITY PRIMARY KEY,
 	 firstName 			VARCHAR(10) NOT NULL,  
     lastName 			VARCHAR(60) NOT NULL,
     username 			VARCHAR(10) NOT NULL,  
     password 			VARCHAR(60) NOT NULL,
     email 				VARCHAR(60) NOT NULL,
	 corporation 		VARCHAR(60) NOT NULL,
	 gender 			VARCHAR(60) NOT NULL,
	 residence 			VARCHAR(60) NOT NULL,
	 street 			VARCHAR(60) NOT NULL,
	 zipcode 			VARCHAR(60) NOT NULL,
	 phone 				VARCHAR(60) NOT NULL
);  

CREATE TABLE IF NOT EXISTS user_authority (
	user_id 			INTEGER NOT NULL,
	authority_id 		INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS authority (
	id 					INTEGER IDENTITY PRIMARY KEY,
	name 				VARCHAR(60) NOT NULL
);


DROP TABLE event IF EXISTS;
DROP TABLE audio IF EXISTS;
DROP TABLE catering IF EXISTS;

CREATE TABLE IF NOT EXISTS event (
  id         			INTEGER IDENTITY PRIMARY KEY,
  name 		 			VARCHAR(60),
  date 					datetime,
  audio_id INTEGER NOT NULL,
  catering_cateringId INTEGER NOT NULL,
  light_lightId INTEGER NOT NULL,
  location_locationId INTEGER NOT NULL,
  rigging_riggingId INTEGER NOT NULL,
  security_securityId INTEGER NOT NULL,
  specialty_specialtyId INTEGER NOT NULL,
  user_userId INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS audio (
	id					INTEGER IDENTITY PRIMARY KEY,
	audioNeeded			TINYINT,
	audioType			VARCHAR(100),
	roomSize			INTEGER NOT NULL,
	numberGuests		INTEGER NOT NULL	
);

CREATE TABLE IF NOT EXISTS catering (
	cateringId			INTEGER IDENTITY PRIMARY KEY,
	eating 				TINYINT,
	eatingType			VARCHAR(100),
	eatingPeople		INTEGER NOT NULL,
	drinking 			TINYINT,
	drinkingPeople		INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS light (
	lightId				INTEGER IDENTITY PRIMARY KEY,
	lightsNeeded 		TINYINT,
	lightType			VARCHAR(100),
	stageSize			INTEGER NOT NULL,
	roomSize			INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS location (
	locationId			INTEGER IDENTITY PRIMARY KEY,
	name 				VARCHAR(100),
	street				VARCHAR(100),
	town				VARCHAR(100),
	type				VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS rigging (
	riggingId			INTEGER IDENTITY PRIMARY KEY,
	riggingNeeded		TINYINT,
	riggingType			VARCHAR(100),
	stageSize			VARCHAR(100)
	
);

CREATE TABLE IF NOT EXISTS security (
	securityId			INTEGER IDENTITY PRIMARY KEY,
	securityNeeded 		TINYINT,
	numberOfProtectees 	INTEGER
);

CREATE TABLE IF NOT EXISTS specialty (
	specialtyId			INTEGER IDENTITY PRIMARY KEY,
	subject				VARCHAR(100),
	comment				VARCHAR(100)
);
