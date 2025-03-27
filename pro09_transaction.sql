CREATE table bank_acount(
 accNo varchar2(20),
 accName VARCHAR2(20),
 balance NUMBER
 );
 SELECT * FROM bank_acount;   
  insert into bank_acount VALUES('100-100-1002', '이순신', 1000000);
 insert into bank_acount VALUES('100-100-1001', '홍길동', 1000000);
 commit;
