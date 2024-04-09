ALTER TABLE
    physicians
ADD COLUMN
    phone VARCHAR(20);

UPDATE
    physicians ph
SET
    phone = '00-00000-0000'
WHERE
    ph.phone IS NULL;

ALTER TABLE
    physicians
ALTER COLUMN
    phone
SET NOT NULL;