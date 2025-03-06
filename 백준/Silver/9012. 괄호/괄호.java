import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();  // 개행 문자 처리

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            int count = 0;
            boolean isValid = true;

            for (char c : str.toCharArray()) {
                if (c == '(') {
                    count++;
                } else {
                    if (count == 0) {  // '('가 없는데 ')'가 나오는 경우
                        isValid = false;
                        break;
                    }
                    count--;
                }
            }

            System.out.println((isValid && count == 0) ? "YES" : "NO");
        }
    }
}
