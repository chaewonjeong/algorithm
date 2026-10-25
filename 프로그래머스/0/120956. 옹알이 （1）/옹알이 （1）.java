class Solution {
    public int solution(String[] babbling) {
        String[] bab = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        
        for(String word : babbling){
            boolean[] used = new boolean[4];
            int idx = 0;
            
            while (idx < word.length()) {
                boolean matched = false;
                
                for(int i = 0; i < bab.length; i++){
                    if(!used[i] && word.startsWith(bab[i], idx)) {
                        idx += bab[i].length();
                        used[i] = true;
                        matched = true;
                        break;
                    }
                }
                
                if(!matched){
                    break;
                }
            }
            
            if(idx == word.length()) {
                answer++;
            }
            
            
        }
        
        
        return answer;
    }
}