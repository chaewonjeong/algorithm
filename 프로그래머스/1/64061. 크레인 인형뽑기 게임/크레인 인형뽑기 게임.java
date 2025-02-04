import java.util.Stack;

class Solution {
    public boolean checkStack(Stack<Integer> stack, int m) {
        return !stack.isEmpty() && m == stack.peek();
    }
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {  // moves 배열에서 직접 가져오기
            int col = move - 1; // moves는 1-based index이므로 0-based로 변환
            int j = 0;

            while (j < board.length && board[j][col] == 0) {
                j++;
            }

            // 모든 행이 0이면 continue (즉, 인형이 없는 경우)
            if (j == board.length) {
                continue;
            }

            int doll = board[j][col]; // 선택된 인형
            board[j][col] = 0; // 인형을 뽑았으므로 해당 위치를 0으로 변경
            
            if (checkStack(stack, doll)) {
                stack.pop();
                answer += 2; // 두 개가 없어지므로 +2
            } else {
                stack.push(doll);
            }
        }
        
        return answer;
    }
}