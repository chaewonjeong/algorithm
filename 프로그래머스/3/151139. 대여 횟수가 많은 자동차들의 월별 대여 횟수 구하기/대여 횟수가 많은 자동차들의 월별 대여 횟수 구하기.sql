/*
- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 
- 총 대여 횟수가 5회 이상인 차에 대해서

월별/ 자동차 ID별 총 대여 횟수(sum??)

월을 기준으로 오름차순. 월이 같다면 자동차 id를 기준으로 내림차순

월의 대여횟수가 0이면 제외
*/

SELECT MONTH(start_date) as month, car_id, COUNT(history_id) as RECORDS FROM car_rental_company_rental_history
WHERE car_id IN ( SELECT car_id FROM car_rental_company_rental_history
                    WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31' 
                    GROUP BY car_id
                    HAVING COUNT(car_id) >= 5 )
    AND start_date BETWEEN '2022-08-01' AND '2022-10-31' 
GROUP BY month, car_id
ORDER BY month, car_id DESC



