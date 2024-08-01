create table EDU_STUDENT.EVACAUATIONFACILITY(
    SERIAL CHAR(4 BYTE) primary key,
    ADDRESS NVARCHAR2(50),
    EFTYPE CHAR(2 BYTE),
    EFCAPACITY NUMBER(5),
    FLOORS NUMBER(5),
    VILLAGE CHAR(4 BYTE)
);

alter table EDU_STUDENT.EVACAUATIONFACILITY
 add foreign key(類別) references 設施類別(類別代號);

alter table 苗栗縣警察局防空疏散避難設施
 add foreign key(村里別代號) references 轄管村里聯絡資訊(村里別代號);


create table EDU_STUDENT.設施類別(
    類別代號 CHAR(2 BYTE) primary key,
    類別 NVARCHAR2(10)
);

create table EDU_STUDENT.VILLAGEINFOR(
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


