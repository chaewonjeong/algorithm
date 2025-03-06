import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < T; i++){
            Stack<Character> stack = new Stack<>();
            
            String str = sc.nextLine();
            for(char c : str.toCharArray()){
                if(c == '('){
                    stack.push(c);
                } else {
                    if(!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                            continue;
                        }
                    }
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }            
        }
    }
}