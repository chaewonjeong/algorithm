import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int n;
    static int m;

    static void dfs(int k, int[] visited, ArrayList<Integer> result) {
        if(k == m){
            for(int i = 0; i < result.size(); i++){
                System.out.print(result.get(i)+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] == 0){
                visited[i] = 1;
                result.add(nums[i]);
                dfs(k+1, visited, result);
                visited[i] = 0;
                result.remove(result.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0,new int[n], new ArrayList<>());
    }
}
