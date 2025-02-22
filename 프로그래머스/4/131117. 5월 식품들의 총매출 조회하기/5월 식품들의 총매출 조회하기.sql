-- 산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출
-- o.product_id, product_name, (price * amount) AS TOTAL_SALES 
-- 코드를 입력하세요
SELECT o.product_id, product_name, (price * SUM(amount)) AS TOTAL_SALES  FROM FOOD_PRODUCT AS P 
        JOIN FOOD_ORDER AS O
        ON p.product_id = o.product_id

WHERE MONTH(PRODUCE_DATE) = 5
GROUP BY PRODUCT_ID

ORDER BY TOTAL_SALES DESC, o.product_id ASC