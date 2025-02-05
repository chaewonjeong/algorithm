import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {       
        ArrayDeque<String> qeue1 = new ArrayDeque<>();
        ArrayDeque<String> qeue2 = new ArrayDeque<>();
        ArrayDeque<String> goalQeue = new ArrayDeque<>();
        ArrayList<ArrayDeque<String>> qeueList = new ArrayList<>();

        for(int i = 0; i < cards1.length; i++){
            qeue1.add(cards1[i]);
        }
        
        for(int i = 0; i < cards2.length; i++){
            qeue2.add(cards2[i]);
        }
        
        for(int i = 0; i < goal.length; i++){
            goalQeue.add(goal[i]);
        }
        
        qeueList.add(qeue1);
        qeueList.add(qeue2);
        
        
        while(!goalQeue.isEmpty()){
            String word = goalQeue.poll();
            boolean poss = false;
            
            for(int i = 0; i < qeueList.size(); i++){
                if(word.equals(qeueList.get(i).peek())){
                    qeueList.get(i).poll();
                    poss = true;
                    break;
                }
            }
            if(poss == false){
                return "No";
            }
        }
               
        return "Yes";
        
    }
}