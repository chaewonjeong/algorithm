import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer;
        
        HashSet<Integer> pocketSet = new HashSet<>();
        
        int N = nums.length;
        
        for(int n : nums){
            pocketSet.add(n);
        }
        answer = pocketSet.size() < N/2 ? pocketSet.size() : N/2;
        return answer;
    }
}