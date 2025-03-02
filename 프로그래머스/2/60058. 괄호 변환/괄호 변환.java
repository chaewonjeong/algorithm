import java.lang.StringBuilder;
import java.util.Stack;

class Solution {
    
    static boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        
        for(Character c : str.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            } else {
                if(stack.peek() == '(' && c == ')'){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
    
    static String reverseStr(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str.length()-1; i++){
            if (str.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
    
    
    static String splitStr(String str){
        if(str.isEmpty()) return str;
        
        StringBuilder sb = new StringBuilder();
        
        int open = 0;
        int close = 0;
        int idx = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') {
                open++;
            }
            else close++;
            if(open == close){
                idx = i + 1;
                break;
            }          
        }
        
        String u = str.substring(0,idx);
        String v = str.substring(idx);
        
        if(isRight(u)){
            sb.append(u).append(splitStr(v));
        } else {
            sb.append("(").append(splitStr(v)).append(")").append(reverseStr(u));
        }
        return sb.toString();
    }
    
    public String solution(String p) {
        String answer = splitStr(p);
        return answer;
    }
}