CREATE TABLE board (
    articleNo NUMBER(10) PRIMARY KEY,
    parentNo NUMBER(10) DEFAULT 0,
    title VARCHAR2(500) NOT NULL,
    content VARCHAR2(4000),
    imageFilename VARCHAR2(30),
    writeDate DATE DEFAULT SYSDATE NOT NULL,
    id VARCHAR2(10),
    CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES member(id)
);

insert into board values(1, 0, '테스트', '테스트글입니다', null, sysdate, 'hong');
insert into board values(2, 0, '테스트2', '테스트글입니다2', null, sysdate, 'hong');
insert into board values(3, 2, '답글', '답글테스트글입니다', null, sysdate, 'hong');
insert into board values(4, 3, '답글2', '답글테스트글입니다2', null, sysdate, 'hong');
insert into board values(5, 0, '테스트3', '테스트글입니다3', null, sysdate, 'hong');
insert into board values(6, 2, '답글3', '답글테스트글입니다3', null, sysdate, 'hong');

-- 오라클(Oracle)에서만 지원하는 계층형 쿼리
-- 게시판 트리 구조 (부모글-답글 구조) 같은 걸 조회할 때 사용
-- start with parentNo =0 
-- 이 구문이 계층형 쿼리의 출발점(root 노드)을 정하는 부분
-- parentNo = 0 인 글부터 시작하겠다는 의미
-- 보통 부모가 없는 글(최상위 글, 즉 원글)을 말함
-- connect by prior articleNo = parentNo
-- 이게 부모-자식 연결 조건
-- 부모글의 articleNo가 자식글의 parentNo와 일치할 때
-- 부모-자식 관계로 봄
-- prior 키워드 -> connect by절 안에서 계층형 관계를 설정할 때 부모쪽 컬럼 앞에 붙여줌
-- 자식 = 현재행, 부모 = prior
-- level
-- 계층형 쿼리에서 제공하는 계층 깊이 정보
-- start with로 시작한 글은 level = 1
-- 그 아래 댓글은 level = 2
-- 그 아래의 답댓글은 lvel = 3
-- 이런 식으로 숫자가 커짐
-- order siblings by articleNo desc
-- 같은 부모를 가진 형제(=siblings)끼리만 정렬
-- articelNo 기준으로 내림차순 정렬
-- 즉, 같은 depth(레벨)에서만 정렬 적용
select level, articleNo, parentNo, title, content, writeDate, imageFileName, id 
from board
start with parentNo = 0
connect by prior articleNo = parentNo
order siblings by articleNo desc;



create table image (
    imageFileNo number primary key not null,
    imageFileName varchar2(100) not null,
    articleNo number not null,
    regDate date default sysdate
);

commit;

