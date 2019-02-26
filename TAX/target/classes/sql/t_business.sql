DROP TABLE IF EXISTS t_business;
CREATE TABLE t_business
(
	address varchar(150) DEFAULT NULL,
  	seq varchar(20) DEFAULT NULL,
  	head varchar(20) DEFAULT NULL,
  	name varchar(80) DEFAULT NULL,
  	capital varchar(50) DEFAULT NULL,
 	founding varchar(50) DEFAULT NULL,
  	receipt varchar(50) DEFAULT NULL,
  	typeCode1 varchar(80) DEFAULT NULL,
  	typeName1 varchar(80) DEFAULT NULL,
  	typeCode2 varchar(80) DEFAULT NULL,
  	typeName2 varchar(80) DEFAULT NULL,
  	typeCode3 varchar(80) DEFAULT NULL,
  	typeName3 varchar(80) DEFAULT NULL,
  	typeCode4 varchar(80) DEFAULT NULL,
  	typeName4 varchar(80) DEFAULT NULL
  	
  	
  	
  	


  	
  	
  	
  	
)
COMMENT 't_business'
COLLATE 'utf8mb4_general_ci'
;