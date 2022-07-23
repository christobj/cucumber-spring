DROP TABLE IF EXISTS visa CASCADE;
CREATE TABLE visa AS SELECT * FROM CSVREAD('classpath:data/user_visa.csv');