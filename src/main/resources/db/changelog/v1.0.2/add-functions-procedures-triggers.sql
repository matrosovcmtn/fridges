-- liquibase formatted sql

-- changeSet Danil:1
CREATE OR REPLACE PROCEDURE add_employee(
    IN first_name varchar(100),
    IN second_name varchar(100),
    IN middle_name varchar(100),
    IN phone_number varchar(100)
)
    LANGUAGE SQL
AS $$
INSERT INTO employee (first_name, second_name, middle_name, phone_number)
VALUES (first_name, second_name, middle_name, phone_number);
$$;

-- changeSet Danil:2
CREATE OR REPLACE PROCEDURE delete_employee(employee_id integer)
AS $$
BEGIN
    DELETE FROM employee WHERE id = employee_id;
END;
$$ LANGUAGE plpgsql;

-- changeSet Danil:3
CREATE OR REPLACE PROCEDURE insert_application(
    creation_date date,
    customer_id integer,
    employee_id integer
)
AS $$
BEGIN
    INSERT INTO application (creation_date, customer_id, employee_id)
    VALUES (creation_date, customer_id, employee_id);
END;
$$ LANGUAGE plpgsql;

-- changeSet Danil:4
CREATE OR REPLACE FUNCTION get_employees_by_specialization(specialization_id integer)
    RETURNS TABLE (
                      employee_id integer,
                      first_name varchar(120),
                      second_name varchar(120),
                      middle_name varchar(120),
                      phone_number varchar(20)
                  ) AS $$
BEGIN
    RETURN QUERY
        SELECT id, e.first_name, e.second_name, e.middle_name, e.phone_number
        FROM employee e
        WHERE spec_id = get_employees_by_specialization.specialization_id;
END;
$$ LANGUAGE plpgsql;

-- changeSet Danil:5
CREATE OR REPLACE FUNCTION get_orders_for_employee(employee_id integer)
    RETURNS TABLE (
                      application_id integer,
                      creation_date date
                  ) AS $$
BEGIN
    RETURN QUERY
        SELECT o.id as application_id, o.creation_date
        FROM application o
        WHERE o.employee_id = get_orders_for_employee.employee_id;
END;
$$ LANGUAGE plpgsql;


-- changeSet Danil:6
CREATE OR REPLACE FUNCTION update_employee_full_name()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.full_name = CONCAT(NEW.second_name, ' ', NEW.first_name, ' ', NEW.middle_name);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- changeSet Danil:7
CREATE TRIGGER set_employee_full_name
    BEFORE INSERT ON employee
    FOR EACH ROW
EXECUTE FUNCTION update_employee_full_name();

-- changeSet Danil:8
CREATE OR REPLACE FUNCTION format_phone_number()
    RETURNS TRIGGER AS $$
BEGIN
    IF NEW.phone_number ~ '^8\d{10}$' THEN
        NEW.phone_number := '+7' || substring(NEW.phone_number from 2);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- changeSet Danil:9
CREATE TRIGGER format_phone_number_trigger
    BEFORE INSERT ON employee
    FOR EACH ROW
EXECUTE FUNCTION format_phone_number();