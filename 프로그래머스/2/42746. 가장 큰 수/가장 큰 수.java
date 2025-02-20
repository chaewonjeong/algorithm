import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {

        String[] intStr = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)) 
            .toArray(String[]::new);
        
        if (intStr[0].equals("0")) {
            return "0";
        }

        return String.join("", intStr);
    }
}