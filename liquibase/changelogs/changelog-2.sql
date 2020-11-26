--liquibase formatted sql

--changeset nikoly:2

CREATE TABLE regular_payments (
regular_payment_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
request_id NUMBER(19) UNIQUE NOT NULL,
source_account NUMBER(19) NOT NULL,
target_account NUMBER(19) NOT NULL,
pay_frequency NUMBER(10) NOT NULL,
CONSTRAINT pk_rp_reg_payment_id
    PRIMARY KEY (regular_payment_id),
CONSTRAINT fk_rp_request_id
    FOREIGN KEY (request_id)
    REFERENCES requests(request_id),
CONSTRAINT fk_rp_source_account
    FOREIGN KEY (source_account)
    REFERENCES accounts(account_id),
CONSTRAINT fk_rp_target_account
    FOREIGN KEY (target_account)
    REFERENCES accounts(account_id)
);

CREATE TABLE payments (
payment_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
source_account_id NUMBER(19) NOT NULL,
target_account_id NUMBER(19) NOT NULL,
regular_payment_id NUMBER(19) NOT NULL,
audit_id NUMBER(19) UNIQUE NOT NULL,
payment_amount NUMBER(38) NOT NULL,
status VARCHAR(255) NOT NULL,
CONSTRAINT pk_pa_payment_id
    PRIMARY KEY (payment_id),
CONSTRAINT fk_pa_source_account_id
    FOREIGN KEY (source_account_id)
    REFERENCES accounts(account_id),
CONSTRAINT fk_pa_target_account_id
    FOREIGN KEY (target_account_id)
    REFERENCES accounts(account_id),
CONSTRAINT fk_pa_reg_payment_id
    FOREIGN KEY (regular_payment_id)
    REFERENCES regular_payments(regular_payment_id),
CONSTRAINT fk_pa_audit_id
    FOREIGN KEY (audit_id)
    REFERENCES audits(audit_id)
);

CREATE TABLE transactions(
transaction_id NUMBER(19) GENERATED ALWAYS AS IDENTITY,
source_account_id NUMBER(19) NOT NULL,
target_account_id NUMBER(19) NOT NULL,
payment_id NUMBER(19) UNIQUE NOT NULL,
CONSTRAINT pk_tr_transaction_id
    PRIMARY KEY (transaction_id),
CONSTRAINT fk_tr_payment_id
    FOREIGN KEY (payment_id)
    REFERENCES payments(payment_id)
);

CREATE INDEX idx_source_account_id
    ON transactions(source_account_id);
    
--changeset nikoly:3

INSERT INTO clients
(first_name, middle_name, surname, birth_date)
VALUES
('Tony', 'Ivanovich', 'Stark', TO_DATE('1994/05/03', 'yyyy/mm/dd'));




