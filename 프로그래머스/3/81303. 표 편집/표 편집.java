import java.util.Stack;
import java.util.Arrays;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i = 0 ; i < n + 2; i++){
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++;
        
        for(String c : cmd){
            if(c.startsWith("C")){
                deleted.push(k);
                // 삭제할 것의 아래의 위는 현재 삭제되는것의 위
                up[down[k]] = up[k];
                
                // 삭제할 것의 위의 아래는 현재 삭제되는것의 아래
                down[up[k]] = down[k];
                k = n < down[k] ? up[k]: down[k];
            } else if (c.startsWith("Z")){
                int restore = deleted.pop();
                // 복원하는 것의 아래의 위는 지금 복원되는 것
                up[down[restore]] = restore;
                
                // 복원하는 것의 위의 아래는 지금 복원되는 것
                down[up[restore]] = restore;
            }
            
            else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                // command에 적힌 offset 만큼 이동하는데 연결리스트 구현 배열을 참고하여 현재 k의 값을 초기화 한다!.
                for (int i = 0; i < x; i++){
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        // for(int i = 0; i < deleted.size(); i++){
        //     answer[deleted.pop() - 1] = 'X';
        // }
        // 위와 같이 풀면 안됨!!....
        // for 문 내에서 pop()을 해버리면 스택의 사이즈가 줄어들어서 결과적으로 내가 원하는 값을 얻지 못함
        
        // 아래처럼 해주거나
        // for(int i : deleted){
        //     answer[i - 1] = 'X';
        // }
        
        while(!deleted.isEmpty()){
            answer[deleted.pop()-1] = 'X';
        }
        
        
        return new String(answer);
    }
}