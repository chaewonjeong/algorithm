import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        ArrayList<String[]> strSetList = new ArrayList<>();
        
        for(String str: strings){
            char c = str.charAt(n);
            String[] strSet = new String[]{String.valueOf(c),str};
            strSetList.add(strSet);
        }
        
        List<String> answer = strSetList.stream()
            .sorted(Comparator.comparing((String[] strSet) -> strSet[0])
                                .thenComparing(strSet -> strSet[1]))
            .map(strSet -> strSet[1])
            .collect(Collectors.toCollection(ArrayList::new));
        
        return answer.toArray(String[]::new);
    }
}