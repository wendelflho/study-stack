ALTER TABLE
    physicians
DROP COLUMN
    active;

ALTER TABLE
    physicians
ADD
    active BOOLEAN;

UPDATE
    physicians
SET
    active = TRUE
WHERE
    active IS NULL;