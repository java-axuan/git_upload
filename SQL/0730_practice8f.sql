select * from WATER1;
select * from SQL_TAOYUAN_REGIONS;
select * from SQL_TAOYUAN_WATER_SYSTEM;


--Á∑¥Áøí7
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
    PLACE,
    SERIAL_NUMBER,
    HYDROGEN,
    TURBIDITY,
    CHLORINE 
from WATER1
where CHLORINE in (0.76,0.77,0.66) and HYDROGEN != 7.8 and TURBIDITY = 0.6
order by TURBIDITY, SERIAL_NUMBER desc;


--ÂÖàÊ∏¨Ë©¶A.B.C JOIN OK (ÂÖà‰∏çÁØ©Ë≥áÊñô)
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
    
    
--Á∑¥Áøí8
select 
    A.SERIAL_NUMBER as "ß«∏π",
    A.HYDROGEN as "¥‚¬˜§lø@´◊",
    A.TURBIDITY as "øB´◊",
    A.CHLORINE as "¶€•—¶≥Æƒæl¥‚",
    C.WATER_PURIFICATION_PLANT as "≤b§Ùºt",
    C.WATER_SUPPLY as "®—§Ù®t≤Œ",
    B.TOWNSHIP as "¶Ê¨F∞œ",
    B.PLACE as "∏Ù¨q"
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

