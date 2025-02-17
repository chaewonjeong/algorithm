class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String vo = "aeiou";
        for(char c: my_string.toCharArray()){
            if(!vo.contains(String.valueOf(c))){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}