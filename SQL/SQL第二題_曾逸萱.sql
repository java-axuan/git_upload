create table �]�߿�ĵ����Ų��������]�I(
    �����]�I�s�� CHAR(4 BYTE) primary key,
    �]�I�a�} NVARCHAR2(50),
    ���O CHAR(2 BYTE),
    �e�H�ƶq NUMBER(5),
    �a�U�Ӽh�� NUMBER(5),
    �����O�N�� CHAR(4 BYTE)
);

alter table �]�߿�ĵ����Ų��������]�I 
add foreign key(���O) references �]�I���O(���O�N��);

alter table �]�߿�ĵ����Ų��������]�I 
add foreign key(�����O�N��) references �Һާ����p����T(�����O�N��);


create table �]�I���O(
    ���O�N�� CHAR(2 BYTE) primary key,
    ���O NVARCHAR2(10)
);

create table �Һާ����p����T(
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


