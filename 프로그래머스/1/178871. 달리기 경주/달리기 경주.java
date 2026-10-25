import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {  
        HashMap<String,Integer> playersMap = new HashMap<>();
        Integer rank = 0;
        
        for(String p : players){
            playersMap.put(p,rank++);
        }
        
        for(String c : callings){
            Integer idx = playersMap.get(c);
            String p1 = players[idx-1];
            String p2 = players[idx];
            
            players[idx-1] = p2;
            players[idx] = p1;
            
            playersMap.put(p1, idx);
            playersMap.put(p2, idx - 1);
        }
        return players;
    }
}