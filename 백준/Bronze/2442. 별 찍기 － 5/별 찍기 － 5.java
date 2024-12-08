import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt(); 

        int k = (n - 1) * 2 + 1;

        for (int j = 1; j <= k; j += 2) {
            System.out.print(" ".repeat((k - j) / 2));
            System.out.println("*".repeat(j));
        }
    }
}