import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static ArrayList<String> combinationList = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // 각 주문의 조합 구하기
        for(String order : orders) {
            char[] menu = order.toCharArray();
            Arrays.sort(menu); // 조합 정렬 (ABC와 ACB를 동일하게)
            combinations(menu, 0, "");
        }
        
        // course 길이에 대해 가장 많이 주문된 조합 구하기
        for(int num : course) {
            HashMap<String, Integer> countMap = new HashMap<>();
            
            for(String combi : combinationList) {
                if(combi.length() == num) {
                    countMap.put(combi, countMap.getOrDefault(combi, 0) + 1);
                }
            }
            
            // 최대 주문 횟수 찾기
            int maxCount = countMap.values().stream()
                                    .max(Integer::compareTo)
                                    .orElse(0);
            
            // 최대 주문 횟수를 가진 조합들 모두 추가
            if(maxCount > 1) {
                List<String> maxOrders = countMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxCount)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
                
                answer.addAll(maxOrders);
            }
        }
        
        return answer.stream().sorted().toArray(String[]::new);
    }
    
    private static void combinations(char[] order, int idx, String result) {
        if(result.length() > 0){
            combinationList.add(result);
        }
        
        for(int i = idx; i < order.length; i++){
            combinations(order, i + 1, result + order[i]);
        }
    }
}
