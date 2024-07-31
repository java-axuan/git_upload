
--left join department name
select distinct EE.DEPARTMENT_ID, DD.DEPARTMENT_NAME, count(EE.EMPLOYEE_ID)
from employees EE, DEPARTMENTS DD
where EE.DEPARTMENT_ID = DD.DEPARTMENT_ID
group by EE.DEPARTMENT_ID, DD.DEPARTMENT_NAME
having count(EE.EMPLOYEE_ID) > 30
order by EE.DEPARTMENT_ID desc;


--���ب��
select min(salary)
from EMPLOYEES;

select count(*) as employees
from EMPLOYEES;
where DEPARTMENT_ID = 90;

select sum(salary) 
from EMPLOYEES;

--�m��9-1
select PLACE,
    count(PLACE),
    max(CHLORINE),
    min(CHLORINE),
    sum(TURBIDITY),  
    avg(TURBIDITY)    

from SQL_TAOYUAN_WATER
where PLACE in ('T40','T44', 'T16')
group by PLACE;

--�m��9-2
select B.TOWNSHIP,
    count(B.TOWNSHIP),
    avg(A.TURBIDITY)
from SQL_TAOYUAN_WATER A
left join SQL_TAOYUAN_REGIONS B
on A.PLACE = B.SERIAL
group by B.TOWNSHIP
having avg(TURBIDITY) > 0.7;

 
--select null, '��T�O��' from dual  --����
create table SQL_EMP_HIS as select * from SQL_EMP;
truncate table SQL_EMP_HIS;
commit;

select * from SQL_EMP_HIS;


--insert into �s�W���   
insert into SQL_EMP1 (EMP_ID, EMP_NM, ID)
values (11124532, '�GA��', 'u123585461');
commit;


insert into SQL_EMP2
select EMP_ID, EMP_NM, ID, '1234#1234' as TEL, '�ŤM���Y��' as DEPT
from SQL_EMP1
where EMP_ID = '11124532';

--�ҫ�m��1
create table SQL_CUSTOMER2 as select * from SQL_CUSTOMER;
truncate table SQL_CUSTOMER2;
commit;

insert into SQL_CUSTOMER2(ID, NAME, EMP)
values('G221133052', '�pO��', '00001578');

--�ҫ�m��2
select *
from(
    select B.CUST_ID,
        C.NAME,
        A.COUNT,
        A.MONEY
    from (
        select *
        from SQL_ORDER_DETAIL
        where ITEM_NO in('C0001', 'C0004', 'C0006', 'C0011')) A
    left join SQL_ORDER B
    on A.ORDER_NO = B.ORDER_NO
    left join SQL_CUSTOMER_STORE C
    on B.CUST_ID = C.CUSTOMER_ID
    order by B.CUST_ID)
where CUST_ID > 0;
