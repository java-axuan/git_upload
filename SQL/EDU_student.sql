select employee_id, last_name, job_id, salary
from employees
where salary in (select min(salary) from employees group by department_id);

--
select employee_id, last_name, job_id, salary
from employees
where salary < ANY
    (select salary
    from employees 
    where job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';

