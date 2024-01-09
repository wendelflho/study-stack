CREATE TABLE physicians (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL CONSTRAINT constraint_email UNIQUE,
    crm VARCHAR(6) NOT NULL CONSTRAINT constraint_crm UNIQUE,
    specialty VARCHAR(100) NOT NULL,
    public_place VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    zip_code VARCHAR(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    fu char(2) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100),

    PRIMARY KEY (id)
);