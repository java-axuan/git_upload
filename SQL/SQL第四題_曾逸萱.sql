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
select C.�Һޤ���,C.�����q�� as �����s���q��, count(C.�Һޤ����N�X) over (partition by C.�Һޤ����N�X) as �����]�I�j��1000�e�H�ƶq���]�I�ƶq
 from �]�߿�ĵ����Ų��������]�I A
 left join �Һާ����p����T B
 on A.�����O�N�� = B.�����O�N��
 left join �Һޤ�����T C
 on B.�Һޤ����N�X = C.�Һޤ����N�X
 where �e�H�ƶq > 1000;
 group by C.�Һޤ���,C.�����q��;

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
    
--4-4
select A.�����]�I�s��,B.�����O, A.�]�I�a�} as �����]�I�a�}, A.�e�H�ƶq, C.�Һޤ���, C.�����q�� as �����s���q��
from
    (select �����]�I�s��,�]�I�a�}, �e�H�ƶq, �����O�N��
    from �]�߿�ĵ����Ų��������]�I 
    where �]�I�a�} like '%��%') A
left join �Һާ����p����T B
on A.�����O�N�� = B.�����O�N��
left join �Һޤ�����T C
on B.�Һޤ����N�X = C.�Һޤ����N�X;

--4-5
select A.�����]�I�s��, B.�����O, B.�����줽�� as �����줽�Ǧ�m, A.�]�I�a�} as �����]�I�a�}, A.�e�H�ƶq
from
    (select �����]�I�s��, �]�I�a�}, �e�H�ƶq, �����O�N��
    from �]�߿�ĵ����Ų��������]�I 
    where ���O in('G1', 'G2')) A
left join �Һާ����p����T B
on A.�����O�N�� = B.�����O�N��;

