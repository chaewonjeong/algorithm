import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> idMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> repotMap = new HashMap<>(); // 신고 당한 사람이 key, 신고한 사람이 배열로 value
        
        for(int i = 0; i < id_list.length; i++){
            String id = id_list[i]; 
            idMap.put(id, i);
        }
        
        for(String r : report){
            String[] rep = r.split(" ");
            
            int user = idMap.get(rep[0]); // 신고한 사람 id index
            
            int repot = idMap.get(rep[1]); // 신고당한 사람 id index
            
            if(!repotMap.containsKey(repot)){
                repotMap.put(repot, new HashSet<>());
            }
            repotMap.get(repot).add(user);
        }
        
        
        
        Map<Integer, HashSet<Integer>> filteredMap = repotMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= k) 
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        
        for(Map.Entry<Integer, HashSet<Integer>> entry : filteredMap.entrySet()){
            for(int i : entry.getValue()){
                answer[i]++;
            }
        }
        
        
        
        return answer;
    }
}