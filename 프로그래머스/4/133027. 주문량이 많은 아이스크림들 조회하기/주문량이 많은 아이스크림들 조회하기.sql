-- 코드를 입력하세요
-- JOIN할 때 외래키를 사용하세요
-- 같은 맛이어도 다른 출하 번호
-- 맛별로 주문량을 고르기
-- 2개의 테이블을 만든 담에 JOIN 해보기
#### 정렬기준이 SELECT에 없으면 어덯게 할까??
SELECT FLAVOR
FROM (
SELECT FLAVOR, SUM(TOTAL_ORDER) AS ORDERS
FROM 
(
SELECT FLAVOR, TOTAL_ORDER FROM JULY 
UNION ALL
SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF 
) AS A
GROUP BY FLAVOR
ORDER BY ORDERS DESC
) AS NEW
LIMIT 3
