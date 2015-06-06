CREATE SCHEMA sidmail;

CREATE TABLE sidmail.login ( 
	id                   int  NOT NULL  ,
	username             varchar(100)    ,
	password             varchar(10)    ,
	CONSTRAINT pk_login PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE TABLE sidmail.`user` ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	user_name            varchar(100)    ,
	first_name           varchar(100)    ,
	last_name            varchar(100)    ,
	CONSTRAINT pk_user PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE TABLE sidmail.email ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	sender               int    ,
	receiver             int    ,
	date_times           date    ,
	subject              varchar(100)    ,
	body                 varchar(500)    ,
	CONSTRAINT pk_email PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_email ON sidmail.email ( sender );

ALTER TABLE sidmail.email ADD CONSTRAINT fk_email FOREIGN KEY ( sender ) REFERENCES sidmail.`user`( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE sidmail.email ADD CONSTRAINT fk_email_0 FOREIGN KEY ( sender ) REFERENCES sidmail.`user`( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

INSERT INTO sidmail.login( id, username, password ) VALUES ( 1, 'sid', '1234' ); 
INSERT INTO sidmail.login( id, username, password ) VALUES ( 2, 'sidona', 'brasov' ); 

INSERT INTO sidmail.`user`( id, user_name, first_name, last_name ) VALUES ( 1, 'Sidona', 'Sidona', 'Donose' ); 
INSERT INTO sidmail.`user`( id, user_name, first_name, last_name ) VALUES ( 2, 'Madalina', 'Gyorgy', 'Madalina' ); 
INSERT INTO sidmail.`user`( id, user_name, first_name, last_name ) VALUES ( 3, 'Ion', 'Popescu', 'Ion' ); 
INSERT INTO sidmail.`user`( id, user_name, first_name, last_name ) VALUES ( 4, 'Maria', 'Pop', 'Maria' ); 

INSERT INTO sidmail.email( id, sender, receiver, date_times, subject, body ) VALUES ( 1, 1, 2, '2015-05-06', 'test', 'test/test' ); 
INSERT INTO sidmail.email( id, sender, receiver, date_times, subject, body ) VALUES ( 2, 1, 3, '2015-01-05', 'Test1', 'Test1:)' ); 
INSERT INTO sidmail.email( id, sender, receiver, date_times, subject, body ) VALUES ( 3, 3, 2, '2015-01-05', 'Teste', 'Teste' ); 
INSERT INTO sidmail.email( id, sender, receiver, date_times, subject, body ) VALUES ( 4, 2, 3, '2015-02-06', 'test03', 'test03' ); 

