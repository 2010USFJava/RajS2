create schema if not exists BankApp authorization sukanya;
set search_path to BankApp; 

create table customer(
user_ID serial primary key,
bank_ID serial,
firstName varchar(20),
lastName varchar(20),
username varchar(20),
userPassword varchar(20)
);

create table bankaccount(
bank_account_ID serial primary key,
balance double precision,
accountType varchar(20)
);

ALTER TABLE customer
ADD UNIQUE (bank_ID),
ADD FOREIGN KEY (bank_ID) REFERENCES bankaccount(bank_account_ID);

create table admin(
adminID serial primary key,
firstName varchar(20),
lastName varchar(20),
username varchar(20),
adminPassword varchar(20)
);

CREATE OR REPLACE FUNCTION bankapp.numoftypechecking()
 RETURNS bigint
 LANGUAGE sql
AS $function$
	select count(accounttype) from bankapp.bankaccount where accounttype='checking';
$function$
;

CREATE OR REPLACE FUNCTION bankapp.numoftypesavings()
 RETURNS bigint
 LANGUAGE sql
AS $function$
	select count(accounttype) from bankapp.bankaccount where accounttype='savings';
$function$
;
