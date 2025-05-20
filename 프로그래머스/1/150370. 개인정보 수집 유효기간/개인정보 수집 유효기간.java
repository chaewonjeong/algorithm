import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 날짜를 다루는 법을 알면 유용하겠군...
        LocalDate todayDate = LocalDate.parse(today.replace(".","-"));
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String term : terms) {
            String t = term.split(" ")[0];
            Integer p = Integer.parseInt(term.split(" ")[1]);
            
            map.put(t, p);
        }
        
        int index = 1;
        for(String privacy : privacies) {
            LocalDate privacyDate = LocalDate.parse(privacy.split(" ")[0].replace(".","-"));
            String t = privacy.split(" ")[1];
            
            long p = (long)map.get(t);
            
            LocalDate updated = privacyDate.plusMonths(p);
            
            if(!updated.isAfter(todayDate)) {
                answer.add(index);
            }
            
            index++;
            
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}