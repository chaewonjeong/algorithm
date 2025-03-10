import java.util.Scanner;

public class Main {
    static int count;
    static void fun(int n){
        if(n < 1) return;

        if (n <= 3) {
            count++;
        }

        fun(n-1);
        fun(n-2);
        fun(n-3);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] test = new int[T];

        for (int i = 0; i < T; i++) {
            test[i] = scanner.nextInt();
        }
        for(int t : test){
            count = 0;
            fun(t);
            System.out.println(count);
        }
    }
}
