-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS A
JOIN ICECREAM_INFO AS B USING (FLAVOR)
GROUP BY B.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC