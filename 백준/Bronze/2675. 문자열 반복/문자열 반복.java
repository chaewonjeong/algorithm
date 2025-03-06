import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < T; i++){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int R = Integer.parseInt(arr[0]);
            
            for(char c : arr[1].toCharArray()){
                for(int j = 0; j < R; j++){
                    System.out.print(c);
                }
            }
            System.out.println();      
        }
    }
}