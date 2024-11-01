-- 코드를 입력하세요
-- INS에는 있는데 OUTS에는 없는 애들
-- DATEDIFF()
-- DATE_FORMAT(COL, '%Y')
SELECT NAME, DATETIME
FROM ANIMAL_INS
WHERE NOT EXISTS (
    SELECT 1 FROM ANIMAL_OUTS WHERE ANIMAL_INS.ANIMAL_ID=ANIMAL_OUTS.ANIMAL_ID)
ORDER BY DATETIME  
LIMIT 3