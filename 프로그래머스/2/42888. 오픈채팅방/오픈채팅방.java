import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();

        ArrayList<String> logs = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        
        
        for(String s : record){
            String[] rec = s.split(" ");   
            
            String cmd = rec[0];
            String uid = rec[1];
            
            if(cmd.equals("Enter")){
                String nickname = rec[2];
                userMap.put(uid, nickname);
                logs.add(uid + " Enter");
            } else if(cmd.equals("Leave")){
                logs.add(uid + " Leave");
            } else if (cmd.equals("Change")){
                String nickname = rec[2];
                userMap.put(uid, nickname);

            }   
        }
        
        for(String log : logs){
            String[] tmp = log.split(" ");
            String uid = tmp[0];
            String cmd = tmp[1];
            
            if(cmd.equals("Enter")){
                answer.add(userMap.get(uid)+"님이 들어왔습니다.");
            } else {
                answer.add(userMap.get(uid)+"님이 나갔습니다.");
            }
            
            
        }
        
        
        return answer.stream().toArray(String[]::new);
    }
}