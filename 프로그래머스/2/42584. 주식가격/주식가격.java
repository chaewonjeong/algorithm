import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 가격이 떨어지는 시점 -> 인접한 원소에대한 처리 -> 스택인가???
        // 스택을 다룰때 뭔가 직접 값을 넣을까?? 아니면 인덱스를 넣을까?? 스택에 어떤 value를 주지??
        
        Stack<Integer> stack = new Stack();
        int n = prices.length - 1;
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int i = stack.pop();
            answer[i] = n - i; 
        }
        
        
        return answer;
    }
}