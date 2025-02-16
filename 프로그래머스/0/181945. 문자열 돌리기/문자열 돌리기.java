import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        for(char c : a.toCharArray()){
            answer+=c;
            answer+="\n";
        }
        System.out.print(answer);
    }
}