import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String result = factorial.toString();
        int count = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
