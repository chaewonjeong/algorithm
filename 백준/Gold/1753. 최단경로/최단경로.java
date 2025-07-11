import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] dist = new int[v + 1];

        Arrays.fill(dist, INF);

        int start = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[v + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[v1].add(new int[]{v2, w});
        }

        pq.add(new int[]{0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curW = cur[0];
            int curV = cur[1];

            if(dist[curV] != curW) continue;

            for (int[] neighbor : graph[curV]) {
                int neighborV = neighbor[0];
                int neighborW = neighbor[1];

                if(dist[neighborV] > dist[curV] + neighborW){
                    dist[neighborV] = dist[curV] + neighborW;
                    pq.add(new int[]{dist[neighborV], neighborV});
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= v; i++) {
            int d = dist[i];
            if(d == INF) {
                answer.append("INF").append("\n");
            } else {
                answer.append(d).append("\n");
            }
        }

        System.out.println(answer);

    }
}
