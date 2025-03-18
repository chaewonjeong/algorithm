import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder answer1 = new StringBuilder();
    static StringBuilder answer2 = new StringBuilder();
    static int[][] dist;
    static int[][] next;

    static void printPath(int start, int end) {
        if (next[start][end] == 0) { // 경로 없음
            answer2.append("0\n");
            return;
        }

        List<Integer> path = new ArrayList<>();
        int cur = start;
        while (cur != end) {
            path.add(cur);
            cur = next[cur][end];
        }
        path.add(end);

        // 경로 개수와 노드 출력
        answer2.append(path.size()).append(" ");
        for (int node : path) {
            answer2.append(node).append(" ");
        }
        answer2.append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = 100000 * (n - 1) + 1;

        dist = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 간선 입력 및 거리 배열 초기화
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (dist[a][b] > c) {
                dist[a][b] = c;
                next[a][b] = b; // 초기 경로 설정
            }
        }

        // 플로이드 워셜 수행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // 경로 갱신
                    }
                }
            }
        }

        // 최단 거리 행렬 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                answer1.append((dist[i][j] == INF) ? "0 " : dist[i][j] + " ");
            }
            answer1.append("\n");
        }

        // 경로 복원 및 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                printPath(i, j);
            }
        }

        // 결과 출력 (StringBuilder 최적화)
        System.out.print(answer1);
        System.out.print(answer2);
    }
}
