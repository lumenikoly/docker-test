--liquibase formatted sql

--changeset nikoly:1

CREATE TABLE clients (
client_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
first_name VARCHAR(255) NOT NULL,
middle_name VARCHAR(255) NOT NULL,
surname VARCHAR(255) NOT NULL,
birth_date VARCHAR(255) NOT NULL,
CONSTRAINT pk_cl_client_id 
    PRIMARY KEY (client_id)
);

CREATE TABLE audits(
audit_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
payment_status VARCHAR(255) NOT NULL,
created_date DATE NOT NULL,
CONSTRAINT pk_au_audit_id
    PRIMARY KEY (audit_id)
);

CREATE TABLE accounts (
account_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
client_id NUMBER(19) NOT NULL,
account_number NUMBER(19) NOT NULL,
CONSTRAINT pk_ac_account_id
    PRIMARY KEY (account_id),
CONSTRAINT fk_ac_client_id
    FOREIGN KEY (client_id)
    REFERENCES clients(client_id)
);
CREATE INDEX idx_ac_client_id
    ON accounts(client_id);

CREATE TABLE balances (
balance_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
account_id NUMBER(19) UNIQUE NOT NULL,
balance_amount NUMBER(38) NOT NULL,
CONSTRAINT pk_ba_balance_id
    PRIMARY KEY (balance_id),
CONSTRAINT fk_ba_account_id
    FOREIGN KEY (account_id)
    REFERENCES accounts(account_id)
);

CREATE TABLE requests (
request_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
client_id NUMBER(19) NOT NULL,
account_id NUMBER(19) NOT NULL,
request_amount NUMBER(38) NOT NULL,
purpose VARCHAR(255),
created_date DATE NOT NULL,
CONSTRAINT pk_re_request_id
    PRIMARY KEY (request_id),
CONSTRAINT fk_re_client_id
    FOREIGN KEY (client_id)
    REFERENCES clients(client_id),
CONSTRAINT fk_re_account_id
    FOREIGN KEY (account_id)
    REFERENCES accounts(account_id)
);


