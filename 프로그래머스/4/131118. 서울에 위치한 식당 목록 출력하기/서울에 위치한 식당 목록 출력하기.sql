SELECT
    i.rest_id
    , i.rest_name
    , i.food_type
    , i.favorites
    , i.address
    , ROUND(AVG(r.review_score), 2) as score   
    FROM rest_info AS i
    JOIN rest_review AS r
    on i.rest_id = r.rest_id
GROUP BY rest_id
HAVING ADDRESS LIKE "서울%"

ORDER BY score DESC, FAVORITES DESC

