import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    // 유니온 파인드 대표 예제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 0 ~ n 까지의 총 n + 1 개의 개별 집합이 주어진다.
        int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 개수

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = -1; // -1로 초기화
        }

        // union 연산 : 0
        // find 연산 : 1

        for (int i = 0; i < m; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(line.nextToken());
            int u = Integer.parseInt(line.nextToken());
            int v = Integer.parseInt(line.nextToken());

            if(cmd == 0){
                union(u,v);
            } else if (cmd == 1){
                if(find(u,v)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int u) {
        if(parent[u] < 0) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }

    private static boolean find(int u, int v){
        return find(u) == find(v);
    }

    private static boolean union(int u, int v) {
        // 랭크 적용
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) return false; // 이미 같은 집합

        // 집합 크기 비교 (음수이므로 절댓값이 더 큰 쪽이 랭크가 더 높음)
        if (parent[rootU] < parent[rootV]) { // rootU가 더 깊은 트리
            parent[rootU] += parent[rootV]; // 랭크(음수) 업데이트
            parent[rootV] = rootU; // rootV를 rootU에 붙임
        } else { // rootV가 더 깊거나 같음
            parent[rootV] += parent[rootU]; // 랭크(음수) 업데이트
            parent[rootU] = rootV; // rootU를 rootV에 붙임
        }
        return true;
    }
}
