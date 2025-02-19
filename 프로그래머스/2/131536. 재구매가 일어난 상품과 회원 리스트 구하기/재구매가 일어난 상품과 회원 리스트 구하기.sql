# SELECT s1.online_sale_id, s1.user_id, s1.product_id, s2.user_id, s2.online_sale_id  FROM ONLINE_SALE AS s1 JOIN ONLINE_SALE AS s2 ON s1.product_id = s2.product_id
# ORDER BY s1.user_id

SELECT user_id, product_id FROM ONLINE_SALE
GROUP BY user_id, product_id
HAVING COUNT(*) >= 2

ORDER BY user_id, product_id DESC