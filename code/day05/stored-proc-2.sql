drop procedure if exists get_emp_data;
delimiter $$ 

create procedure get_emp_data(
    p_empno int,
    out p_firstname varchar(50),
    out p_lastname varchar(50),
    out p_email varchar(100),
    out p_phone varchar(50),
    out p_salary double
) begin
    select fistname, lastname, email, phone, salary
    into p_firstname, p_lastname, p_email, p_phone, p_salary
    from employees
    where empno = p_empno;
end $$ 

delimiter;