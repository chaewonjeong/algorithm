import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                int sum = numbers[i]+numbers[j];
                if(!result.contains(sum)){
                    result.add(sum);
                }
            }
        }

        result.sort(Integer::compareTo);

        return result;
    }
}