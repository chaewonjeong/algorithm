import java.util.Scanner;

public class Main {

    static boolean isValid(String s) {
        if (s.contains("666")){
            return true;
        } else return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 666;
        int count = 0;
        while(count != n){
            if(isValid(String.valueOf(start))){
                count++;
            }
            start++;
        }

        System.out.println(start-1);
    }
}
