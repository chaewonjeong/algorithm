SELECT c.car_id, c.car_type, ROUND(c.daily_fee * 30 * (1-p.discount_rate/100)) as FEE

FROM CAR_RENTAL_COMPANY_CAR AS C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H ON C.car_id = H.car_id
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P ON c.car_type = p.car_type

WHERE
    p.duration_type = '30일 이상'
    AND (c.car_type = '세단' OR c.car_type = 'SUV')
    AND c.car_id NOT IN (
                        SELECT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                        WHERE (start_date <= '2022-11-30' AND end_date >= '2022-11-01')   
    )
GROUP BY c.car_id
HAVING FEE between 500000 AND 2000000
ORDER BY FEE DESC, c.car_type ASC, c.car_id DESC