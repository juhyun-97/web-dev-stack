/*
	DB 모델링 
    1. 개념적 모델링
		- 엔티티(테이블) 추출
        - 엔티티 간의 관계설정
    2. 논리적 모델링
		- 속성(컬럼) 추출
        - 정규화 작업 (1, 2, 3) ----> 이 이상으로 가면 역정규화
    3. 물리적 모델링
		- 테이블 실질적으로 작성 (CREATE 문 작성)
    
    * 정규화(Nomalization)
    - 불필요한 데이터의 중복을 제거하여 데이터모델을 구조화하는 것
    - 효율적인 자료 저장 및 데이터 무결성을 보장하고 오류를 최소화하여 안정성을 
       보장하기 위해 적용함
    
	   제 1 정규화 : 복수의 속성값을 갖는 속성을 분리
       제 2 정규화 : 주 식별자에 종속되지 않는 속성을 분리
       제 3 정규화 : 속성에 종속적인 속성을 제거
*/
/*
	사용자 OR 사원 관련 정보 들어가는 테이블 하나 CREATE 문 작성해서 제출
    
    MySQL
    - 데이터 타입
    1. 문자
		- CHAR / **VARCHAR** : 고정 및 가변 길이 문자, 반드시 크기 지정
        - TEXT : 매우 긴 문자열을 저장하는데 사용
    2. 숫자
		- **INT** : 정수값 저장하는데 사용
        - FLOAT / DOUBLE : 부동소수점 저장하는데 사용
        - DECIMAL : 고정소수점 저장하는데 사용
	3. 날짜 및 시간
		- **DATE** : 날짜 저장하는데 사용
        - TIME : 시간 저장하는데 사용
        - **DATETIME** / TIMESTAMP : 날짜와 시간을 함께 저장
	4. 불리언
		- BOOLEAN / BOOL : 참(True) 또는 거짓(False) 값을 저장하는데 사용
	5. 이진 자료형
		- BLOB : 이진 데이터를 저장하는데 사용, 이미지나 동영상과 같은 이진 파일
        --> 실제로는 이미지나 동영상은 따로 관리 (URL만 문자형으로 저장)
*/
CREATE TABLE USERMG(
	USER_NO INT PRIMARY KEY,
    USER_NAME VARCHAR(10) NOT NULL,
    USER_PHONE VARCHAR(15),
    USER_ADDR VARCHAR(40) NOT NULL,
    USER_BIRTH INT(10) NOT NULL,
    USER_AGE INT(5) NOT NULL,
    USER_GEN VARCHAR(5) NOT NULL
);
INSERT INTO USERMG(USER_NAME, USER_PHONE, USER_ADDR, USER_BIRTH, USER_AGE, USER_GEN)
VALUES('김주현', '010-6866-9533', '경기 안산시 단원구', 970617, 29, '남');
SELECT * FROM USERMG;