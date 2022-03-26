drop procedure if exists add_emp_rec;

delimiter $$

create procedure add_emp_rec(
    p_firstname varchar(50),
    p_lastname varchar(50),
    p_email varchar(100),
    p_phone varchar(50),
    p_salary double
)
begin
    insert into employees (firstname, lastname, email, phone, salary)
    values (p_firstname, p_lastname, p_email, p_phone, p_salary);

end$$

delimiter ;

