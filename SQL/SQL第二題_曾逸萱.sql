create table STUDENT.EVACUATIONFACILITY(
    SERIAL CHAR(4 BYTE) primary key,
    ADDRESS NVARCHAR2(50),
    EFTYPE CHAR(2 BYTE),
    EFCAPACITY NUMBER(5),
    FLOORS NUMBER(5),
    VSERIAL CHAR(4 BYTE)
);

alter table STUDENT.EVACAUATIONFACILITY
 add foreign key(���O) references �]�I���O(���O�N��);

alter table �]�߿�ĵ����Ų��������]�I
 add foreign key(�����O�N��) references �Һާ����p����T(�����O�N��);


create table STUDENT.BUILDINGTYPE(
    BSERIAL CHAR(2 BYTE) primary key,
    BUILDING NVARCHAR2(10)
);

create table STUDENT.VILLAGEINFOR(
    VSERIAL CHAR(4 BYTE) primary key,
    VILLAGE NVARCHAR2(10),
    VADDRESS NVARCHAR2(50),
    VTEL VARCHAR2(10 BYTE),
    PSERIAL CHAR(4 BYTE)
);


create table STUDENT.POLICEINFOR(
    PSERIAL CHAR(4 BYTE) primary key,
    POLICESTAION NVARCHAR2(10),
    PADDRESS NVARCHAR2(50),
    PTEL VARCHAR2(10 BYTE)
);


