import java.util.*;

public class Main {
    public static void main(String args[]){
        int max = Integer.MIN_VALUE;
        int index = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            int n = sc.nextInt();
            if(max < n){
                max = n;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}