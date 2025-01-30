import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()){
                if(c == ')'){
                    return false;
                }
                stack.push(c);
                continue;
            }
            
            if(stack.peek() == c){
                stack.push(c);
            } else if(stack.peek() != c){
                stack.pop();
            }
            
        }

        return stack.isEmpty();
    }
}