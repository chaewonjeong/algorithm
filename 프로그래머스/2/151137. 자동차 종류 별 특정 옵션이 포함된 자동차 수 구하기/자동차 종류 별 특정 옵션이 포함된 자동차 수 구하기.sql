-- '세단', 'SUV', '승합차', '트럭', '리무진' 
-- 키워드 종류는 '주차감지센서', '스마트키', '네비게이션', '통풍시트', '열선시트', '후방카메라', '가죽시트' 

-- 이문제에서 알아야 할 포인트
-- STRING 어떻게 다룰래??
-- java 처럼 split() 함수가 있는건 아님

-- 제약 조건
-- 컬럼명 CARS, 자동차 종류 기준 오름차순

-- 출력
-- 하나 이상의 옵션이 포함된 자동차가 (자동차 종류 별로) 몇대 -> COUNT(*)

SELECT CAR_TYPE, COUNT(*) AS CARS
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS REGEXP '통풍시트|열선시트|가죽시트'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE




