CREATE TABLE schedules(
    id SERIAL NOT NULL,
    physician_id SERIAL NOT NULL,
    patient_id SERIAL NOT NULL,
    date timestamp NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_schedules_physician_id FOREIGN KEY (physician_id) REFERENCES physicians(id),
    CONSTRAINT fk_schedules_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id)
);