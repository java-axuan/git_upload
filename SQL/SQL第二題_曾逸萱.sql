create table EDU_STUDENT.EVACAUATIONFACILITY(
    SERIAL CHAR(4 BYTE) primary key,
    ADDRESS NVARCHAR2(50),
    EFTYPE CHAR(2 BYTE),
    EFCAPACITY NUMBER(5),
    FLOORS NUMBER(5),
    VILLAGE CHAR(4 BYTE)
);

alter table EDU_STUDENT.EVACAUATIONFACILITY
 add foreign key(���O) references �]�I���O(���O�N��);

alter table �]�߿�ĵ����Ų��������]�I
 add foreign key(�����O�N��) references �Һާ����p����T(�����O�N��);


create table EDU_STUDENT.�]�I���O(
    ���O�N�� CHAR(2 BYTE) primary key,
    ���O NVARCHAR2(10)
);

create table EDU_STUDENT.VILLAGEINFOR(
    �����O�N�� CHAR(4 BYTE) primary key,
    �����O NVARCHAR2(10),
    �����줽�� NVARCHAR2(50),
    �����줽�ǹq�� VARCHAR2(10 BYTE),
    �Һޤ����N�X CHAR(4 BYTE)
);


create table �Һޤ�����T(
    �Һޤ����N�X CHAR(4 BYTE) primary key,
    �Һޤ��� NVARCHAR2(10),
    �����a�} NVARCHAR2(50),
    �����q�� VARCHAR2(10 BYTE)
);


