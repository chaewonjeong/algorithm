import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder answer = new StringBuilder();

    static void dfs(ArrayList<Integer> result, int n, int cur, int[] nums) {
        if (n == 6) {
            for (Integer i : result) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            result.add(nums[i]);
            dfs(result, n + 1, i + 1, nums); // ★ i + 1 로 수정
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> result = new ArrayList<>();
            dfs(result, 0, 0, nums); // ★ 이 위치에서 한번만 호출

            answer.append("\n"); // 테스트 케이스 구분
        }

        System.out.print(answer);
    }
}
