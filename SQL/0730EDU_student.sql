select * from WATER1;
select * from SQL_TAOYUAN_REGIONS;
select * from SQL_TAOYUAN_WATER_SYSTEM;


--練習7
select 
    PLACE,
    SERIAL_NUMBER,
    HYDROGEN,
    TURBIDITY,
    CHLORINE 
from WATER1
where SERIAL_NUMBER between 521 and 529

union 

select 
    A.PLACE,
    A.SERIAL_NUMBER,
    HYDROGEN,
    TURBIDITY,
    CHLORINE 
from WATER1
where CHLORINE in (0.76,0.77,0.66) and HYDROGEN != 7.8 and TURBIDITY = 0.6
order by TURBIDITY, SERIAL_NUMBER desc;


--先測試A.B.C JOIN OK (先不篩資料)
select 
    A.SERIAL_NUMBER,
    A.HYDROGEN,
    A.TURBIDITY,
    A.CHLORINE,
    C.WATER_PURIFICATION_PLANT,
    C.WATER_SUPPLY,
    B.TOWNSHIP,
    B.PLACE
from WATER1 A
left join SQL_TAOYUAN_WATER_SYSTEM C
    on A.WATER_SYSTEM = C.SERIAL
left join SQL_TAOYUAN_REGIONS B   
    on A.PLACE = B.SERIAL
    ;
    
    
--練習8
select 
    A.SERIAL_NUMBER,
    A.HYDROGEN,
    A.TURBIDITY,
    A.CHLORINE,
    C.WATER_PURIFICATION_PLANT,
    C.WATER_SUPPLY,
    B.TOWNSHIP,
    B.PLACE
from(select 
    PLACE,
    SERIAL_NUMBER,
    HYDROGEN,
    TURBIDITY,
    CHLORINE,
    WATER_SYSTEM
from WATER1
where SERIAL_NUMBER between 521 and 529

union 

select 
    PLACE,
    SERIAL_NUMBER,
    HYDROGEN,
    TURBIDITY,
    CHLORINE,
    WATER_SYSTEM
from WATER1
where CHLORINE in (0.76,0.77,0.66) and HYDROGEN != 7.8 and TURBIDITY = 0.6
) A

left join SQL_TAOYUAN_WATER_SYSTEM C
    on A.WATER_SYSTEM = C.SERIAL
left join SQL_TAOYUAN_REGIONS B   
    on A.PLACE = B.SERIAL
order by TURBIDITY, SERIAL_NUMBER desc;

