import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                result.add(numbers[i] + numbers[j]);
                }
            }

        return result.stream()
            .distinct()
            .sorted()
            .collect(Collectors.toCollection(ArrayList::new));
    }
}

