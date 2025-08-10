import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }


        for(int tar : target){
            int left = 0;
            int right = n - 1;
            int flag = 0;
            while (left <= right) {
                int mid = (left + right)/2;

                if (arr[mid] < tar) {
                    left = mid + 1;
                } else if (arr[mid] > tar) {
                    right = mid - 1;
                } else {
                    sb.append("1");
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                sb.append("0");
            }
            sb.append('\n');
        }

        System.out.println(sb);




    }
}
