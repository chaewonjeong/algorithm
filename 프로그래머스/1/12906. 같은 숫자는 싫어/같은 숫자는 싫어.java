import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr){
            if(!stack.isEmpty() && stack.peek() == i){
                continue;
            } else {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);
        
        return list.stream().mapToInt(i -> i).toArray(); 
    }
}