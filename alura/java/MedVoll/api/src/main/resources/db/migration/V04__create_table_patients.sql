CREATE TABLE patients(
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL CONSTRAINT email_constraint UNIQUE,
    phone VARCHAR(20) NOT NULL,
    tax_id VARCHAR(11) NOT NULL CONSTRAINT tax_id_constraint UNIQUE,
    public_place VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    zip_code VARCHAR(9) NOT NULL,
    city VARCHAR(100) NOT NULL,
    fu char(2) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100),

    PRIMARY KEY (id)
);