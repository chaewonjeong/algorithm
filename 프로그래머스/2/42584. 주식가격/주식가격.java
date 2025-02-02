import java.util.ArrayList;

class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> answer = new ArrayList();
        for(int i = 0; i < prices.length; i++){
            int count = 0;
            int flag = 0;
            for(int j = i+1; j < prices.length; j++){
                count++;
                if(prices[j] < prices[i]){
                    flag = 1;
                    answer.add(count);
                    break;
                }
            }
            if(flag == 0) answer.add(count);
            
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}