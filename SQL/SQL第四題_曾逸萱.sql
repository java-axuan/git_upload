--4-1
select PI.POLICESTATION as 轄管分局, PI.PTEL as 分局連絡電話
 from
    (select distinct PSERIAL
     from STUDENT.VILLAGEINFOR 
     where VSERIAL in(
        select VSERIAL
         from STUDENT.EVACUATIONFACILITY
         where EFCAPACITY > 1000)) PS
 left join STUDENT.POLICEINFOR PI
 on PS.PSERIAL = PI.PSERIAL;

--4-2
select C.轄管分局,C.分局電話 as 分局連絡電話, count(C.轄管分局代碼) over (partition by C.轄管分局代碼) as 避難設施大於1000容人數量的設施數量
 from 苗栗縣警察局防空疏散避難設施 A
 left join 轄管村里聯絡資訊 B
 on A.村里別代號 = B.村里別代號
 left join 轄管分局資訊 C
 on B.轄管分局代碼 = C.轄管分局代碼
 where 容人數量 > 1000;
 group by C.轄管分局,C.分局電話;

--4-3
    select C.轄管分局, C.分局電話, A.設施地址 as 避難設施地址, D.類別, EE.避難設施大於1000容人數量的設施數量
    from
        (select 設施地址, 類別, 村里別代號
        from 苗栗縣警察局防空疏散避難設施
        where 容人數量 > 1000) A
    left join 設施類別 D
    on A.類別 = D.類別代號
    left join 轄管村里聯絡資訊 B
    on A.村里別代號 = B.村里別代號
    left join 轄管分局資訊 C
    on B.轄管分局代碼 = C.轄管分局代碼
    
    left join 
       ( select C.轄管分局,C.分局電話 as 分局連絡電話, count(C.轄管分局代碼) as 避難設施大於1000容人數量的設施數量
        from
        (select 轄管分局代碼
        from 轄管村里聯絡資訊 B
        where 村里別代號 in(
            select 村里別代號
            from 苗栗縣警察局防空疏散避難設施
            where 容人數量 > 1000)) B
        left join 轄管分局資訊 C
        on B.轄管分局代碼 = C.轄管分局代碼
        group by C.轄管分局,C.分局電話) EE

    on C.轄管分局 = EE.轄管分局;
    
--4-4
select A.避難設施編號,B.村里別, A.設施地址 as 避難設施地址, A.容人數量, C.轄管分局, C.分局電話 as 分局連絡電話
from
    (select 避難設施編號,設施地址, 容人數量, 村里別代號
    from 苗栗縣警察局防空疏散避難設施 
    where 設施地址 like '%中%') A
left join 轄管村里聯絡資訊 B
on A.村里別代號 = B.村里別代號
left join 轄管分局資訊 C
on B.轄管分局代碼 = C.轄管分局代碼;

--4-5
select A.避難設施編號, B.村里別, B.村里辦公室 as 村里辦公室位置, A.設施地址 as 避難設施地址, A.容人數量
from
    (select 避難設施編號, 設施地址, 容人數量, 村里別代號
    from 苗栗縣警察局防空疏散避難設施 
    where 類別 in('G1', 'G2')) A
left join 轄管村里聯絡資訊 B
on A.村里別代號 = B.村里別代號;

