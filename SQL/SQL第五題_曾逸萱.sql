--5-1
create table 苗栗縣警察局防空疏散避難設施1 as select * from 苗栗縣警察局防空疏散避難設施 ; 

update 苗栗縣警察局防空疏散避難設施1
set 容人數量 = 5000
where 設施地址 = '苗栗縣竹南鎮和平街79號';

--5-2
delete from 苗栗縣警察局防空疏散避難設施1
where 容人數量 < 1000;