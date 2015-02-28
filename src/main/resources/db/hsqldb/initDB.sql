DROP TABLE users IF EXISTS;
DROP TABLE authorities IF EXISTS;
DROP TABLE user_authorities IF EXISTS;
DROP TABLE authority IF EXISTS;
DROP TABLE location IF EXISTS;

CREATE TABLE IF NOT EXISTS users (
 	 id 				INTEGER IDENTITY PRIMARY KEY,
 	 firstName 			VARCHAR(60) NOT NULL,  
     lastName 			VARCHAR(60) NOT NULL,
     username 			VARCHAR(60) NOT NULL,  
     password 			VARCHAR(120) NOT NULL,
     email 				VARCHAR(60) NOT NULL
);  

CREATE TABLE IF NOT EXISTS user_authority (
	user_id 			INTEGER NOT NULL,
	authority_id 		INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS authority (
	id 					INTEGER IDENTITY PRIMARY KEY,
	name 				VARCHAR(60) NOT NULL
);

CREATE TABLE location (
  zip int(11) DEFAULT NULL,
  ort varchar(255) DEFAULT NULL,
  kreis varchar(255) DEFAULT NULL,
  bundesland varchar(255) DEFAULT NULL,
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;