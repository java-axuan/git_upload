create table 苗栗縣警察局防空疏散避難設施(
    避難設施編號 CHAR(4 BYTE) primary key,
    設施地址 NVARCHAR2(50),
    類別 CHAR(2 BYTE),
    容人數量 NUMBER(5),
    地下樓層數 NUMBER(5),
    村里別代號 CHAR(4 BYTE)
);

alter table 苗栗縣警察局防空疏散避難設施 
add foreign key(類別) references 設施類別(類別代號);

alter table 苗栗縣警察局防空疏散避難設施 
add foreign key(村里別代號) references 轄管村里聯絡資訊(村里別代號);


create table 設施類別(
    類別代號 CHAR(2 BYTE) primary key,
    類別 NVARCHAR2(10)
);

create table 轄管村里聯絡資訊(
    村里別代號 CHAR(4 BYTE) primary key,
    村里別 NVARCHAR2(10),
    村里辦公室 NVARCHAR2(50),
    村里辦公室電話 VARCHAR2(10 BYTE),
    轄管分局代碼 CHAR(4 BYTE)
);


create table 轄管分局資訊(
    轄管分局代碼 CHAR(4 BYTE) primary key,
    轄管分局 NVARCHAR2(10),
    分局地址 NVARCHAR2(50),
    分局電話 VARCHAR2(10 BYTE)
);


