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
    static StringBuilder answer = new StringBuilder();

    static void dfs(int k, int[] visited, ArrayList<Integer> result) {
        if(k == m){
            // 매번 System.out.println을 호출하면 시간이 오래 걸림
            for(int i = 0; i < result.size(); i++){
                answer.append(result.get(i)).append(" ");
            }
            answer.append("\n");
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
        int[] visited = new int[n];
        ArrayList<Integer> result = new ArrayList<>();

        dfs(0,visited,result);
        System.out.println(answer);
    }
}
