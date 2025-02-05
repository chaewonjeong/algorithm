import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            deque.add((int) Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        
        while(!deque.isEmpty()){
            int count = 0;
            int day = deque.poll();
            count++;
            while(!deque.isEmpty() && day >= deque.peek()){
                deque.poll();
                count++;
            }
            answer.add(count);
            
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}