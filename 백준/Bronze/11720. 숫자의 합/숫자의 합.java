import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args){
        // stream() 연습용 코드..
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        
        int answer = str.chars().map(c -> Character.getNumericValue(c))
            .sum();
            
        System.out.println(answer);
        
    }
}