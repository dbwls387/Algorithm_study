SELECT COUNT(DISTINCT(NAME)) AS count 
  FROM ANIMAL_INS; 
 
 -- COUNT 함수가 NULL을 제거하고 세어주기 때문에 아래 구절은 필요 없음 
 -- WHERE NAME IS NOT NULL; 