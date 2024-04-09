ALTER TABLE
    patients
ADD COLUMN
    active BOOLEAN;

UPDATE
    patients ph
SET
    active = TRUE
WHERE
    ph.active IS NULL