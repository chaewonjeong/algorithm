import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack();
        int n = prices.length;
        int[] answer = new int[n];
        stack.push(0);
        
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int j = stack.pop();
                answer[j] = i-j;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = n - j - 1;
        }
        
        
        return answer;
    }
}