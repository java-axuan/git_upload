--4-1
select PI.POLICESTATION as �Һޤ���, PI.PTEL as �����s���q��
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
select PI.POLICESTATION, PI.PTEL as �����s���q��, count(PI.PSERIAL) over (partition by PI.PSERIAL) as �����]�I�j��1000�e�H�ƶq���]�I�ƶq
 from STUDENT.EVACUATIONFACILITY EF
 left join STUDENT.VILLAGEINFOR VI
 on EF.VSERIAL = VI.VSERIAL
 left join STUDENT.POLICEINFOR PI
 on VI.PSERIAL = PI.PSERIAL
 where EFCAPACITY > 1000;


--4-3
    select C.�Һޤ���, C.�����q��, A.�]�I�a�} as �����]�I�a�}, D.���O, EE.�����]�I�j��1000�e�H�ƶq���]�I�ƶq
    from
        (select �]�I�a�}, ���O, �����O�N��
        from �]�߿�ĵ����Ų��������]�I
        where �e�H�ƶq > 1000) A
    left join �]�I���O D
    on A.���O = D.���O�N��
    left join �Һާ����p����T B
    on A.�����O�N�� = B.�����O�N��
    left join �Һޤ�����T C
    on B.�Һޤ����N�X = C.�Һޤ����N�X
    
    left join 
       ( select C.�Һޤ���,C.�����q�� as �����s���q��, count(C.�Һޤ����N�X) as �����]�I�j��1000�e�H�ƶq���]�I�ƶq
        from
        (select �Һޤ����N�X
        from �Һާ����p����T B
        where �����O�N�� in(
            select �����O�N��
            from �]�߿�ĵ����Ų��������]�I
            where �e�H�ƶq > 1000)) B
        left join �Һޤ�����T C
        on B.�Һޤ����N�X = C.�Һޤ����N�X
        group by C.�Һޤ���,C.�����q��) EE

    on C.�Һޤ��� = EE.�Һޤ���;

--4-3
    select C.�Һޤ���, C.�����q��, A.�]�I�a�} as �����]�I�a�}, D.���O, EE.�����]�I�j��1000�e�H�ƶq���]�I�ƶq
    from �]�߿�ĵ����Ų��������]�I A
    left join �]�I���O D
    on A.���O = D.���O�N��
    left join �Һާ����p����T B
    on A.�����O�N�� = B.�����O�N��
    left join �Һޤ�����T C
    on B.�Һޤ����N�X = C.�Һޤ����N�X
    where �e�H�ƶq > 1000
    
    left join 
       ( select C.�Һޤ���,C.�����q�� as �����s���q��, count(C.�Һޤ����N�X) as �����]�I�j��1000�e�H�ƶq���]�I�ƶq
        from
        (select �Һޤ����N�X
        from �Һާ����p����T B
        where �����O�N�� in(
            select �����O�N��
            from �]�߿�ĵ����Ų��������]�I
            where �e�H�ƶq > 1000)) B
        left join �Һޤ�����T C
        on B.�Һޤ����N�X = C.�Һޤ����N�X
        group by C.�Һޤ���,C.�����q��) EE

    on C.�Һޤ��� = EE.�Һޤ���;
    
    
--4-4
select EF.SERIAL, VI.VSERIAL, EF.ADDRESS as �����]�I�a�}, EF.EFCAPACITY, PI.POLICESTAION, PI.PTEL as �����s���q��
 from STUDENT.EVACUATIONFACILITY EF
 left join STUDENT.VILLAGEINFOR VI
 on EF.VSERIAL = VI.VSERIAL
 left join STUDENT.POLICEINFOR PI
 on VI.PSERIAL = PI.PSERIAL
 where ADDRESS like '%��%';

--4-5
select EF.SERIAL, B.VILLAGE, B.VADDRESS as �����줽�Ǧ�m, EF.ADDRESS as �����]�I�a�}, EF.EFCAPACITY
 from STUDENT.EVACUATIONFACILITY EF
 left join STUDENT.VILLAGEINFOR VI
 on EF.VSERIAL = VI.VSERIAL
 where EFTYPE in('G1', 'G2');

