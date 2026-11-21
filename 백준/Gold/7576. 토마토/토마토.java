import java.util.*;
import java.io.*;

public class Main {

    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        //정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int tomato = Integer.parseInt(st.nextToken());
                board[i][j] = tomato;
                visited[i][j] = -1;
                if(tomato == 1) {
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                } else if (tomato == -1) {
                    visited[i][j] = 0;
                }

            }
        }

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0 && newRow <n && newCol >=0 && newCol <m){
                    if(board[newRow][newCol] == 0 && visited[newRow][newCol] == -1){
                        visited[newRow][newCol] = visited[row][col] + 1;
                        queue.add(new int[] {newRow, newCol});
                    }
                }
            }

        }

        // 최솟값
        int min = Arrays.stream(visited)
                .flatMapToInt(Arrays::stream)
                .min()
                .getAsInt();

        // 최댓값
        int max = Arrays.stream(visited)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();

        if(min == 1 && max == 1) {
            System.out.println(0);
            return;
        } else if(min == -1){
            System.out.println(-1);
            return;
        }

        System.out.println(max-1);






    }
}
