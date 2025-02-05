import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {        
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>(); 
        
        for(String name : participant){
            if(map.containsKey(name)){
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
            
        }
        
        for(String name : completion){
            if(map.containsKey(name) && map.get(name) == 1){
                map.remove(name);
            } else if(map.containsKey(name) && map.get(name) > 1){
                map.put(name, map.get(name) - 1);
            }
        }
        
        
        for(String name : map.keySet()){
            answer = name;
        }
        return answer; 
    }
}