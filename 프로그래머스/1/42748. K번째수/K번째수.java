import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            // skip(i) : 스트림 요소의 처음 i를 건너뛴다
            // limit(j) : 스트림 요소를 j개로 제한한다.
            
            
            List<Integer> result = Arrays.stream(array).skip(i-1).limit(j-i+1)
                .sorted().boxed().collect(Collectors.toList());
            
            answer.add(result.get(k-1));
        }
        

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}