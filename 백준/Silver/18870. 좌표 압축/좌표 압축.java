import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int lowerSearch(int target, int[] arr){
        int left = 0;
        int right = arr.length;

        while(left < right){
            int mid = (left+right)/2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }



    // x 를 압축한 결과 -> x 보다 작은 수들의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int[] sorted = new int[set.size()];
        int index = 0;
        for (int i : set) {
            sorted[index++] = i;
        }
        Arrays.sort(sorted);

        for (int i : nums) {
            int o = lowerSearch(i, sorted);
            answer.append(o).append(" ");
        }

        System.out.println(answer);
    }
}
