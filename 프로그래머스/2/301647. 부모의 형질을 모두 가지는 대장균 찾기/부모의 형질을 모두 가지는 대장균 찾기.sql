SELECT A.ID, A.GENOTYPE, B.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS A, ECOLI_DATA AS B
WHERE A.PARENT_ID=B.ID AND (A.GENOTYPE & B.GENOTYPE)=B.GENOTYPE
ORDER BY A.ID ASC 
