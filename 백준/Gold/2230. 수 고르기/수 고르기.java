import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int dif = 0;

        while (end < n) {
            if (start == end) {
                end++;
            }
            if(end == n) break;
            dif = nums[end] - nums[start];

            if(dif >= m){
                answer = Math.min(answer, dif);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(answer);
    }
}
