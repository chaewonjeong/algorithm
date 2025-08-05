import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;

    static int[][] board;
    static boolean[][] visited;
    static int[][] dists = {{1,0}, {0,1}, {-1,0}, {0,-1}};


    static int bfs(int startR, int startC) {
        int count = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        count++;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dist: dists) {
                int newR = cur[0] + dist[0];
                int newC = cur[1] + dist[1];


                if (newR >= 0 && newR < board.length
                        && newC >= 0 && newC < board[0].length) {
                    if(board[newR][newC] == 1 && visited[newR][newC] == false) {
                        queue.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                        count++;
                    }
                }
            }
        }


        return count;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 &&  visited[i][j] == false) {
                    count++;
                    max = Math.max(bfs(i,j), max);
                }
            }
        }

        System.out.println(count);
        if(max == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }
}
