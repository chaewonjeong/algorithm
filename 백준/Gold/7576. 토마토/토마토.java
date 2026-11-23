import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //int [][] board = new int[n][m];
        int [][] visited = new int[n][m];

        Queue<int []> queue = new ArrayDeque<>();

        int count_1 = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int tomato = Integer.parseInt(st.nextToken());
                if(tomato == 1) {
                    visited[i][j] = tomato;
                    queue.add(new int[]{i, j});
                } else if (tomato == 0) {
                    count_1++;
                } else if (tomato == -1){
                    visited[i][j] = tomato;
                }
            }
        }

        if(count_1 == 0){
            System.out.println(0);
            return;
        }

        int count_2 = 0;
        int max = 0;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    if(visited[newRow][newCol] == 0){
                        visited[newRow][newCol] = visited[row][col] + 1;

                        max = Math.max(max,visited[newRow][newCol]);

                        queue.add(new int[] {newRow, newCol});
                        count_2++;
                    }
                }
            }
        }

        System.out.println(count_1 > count_2 ? -1 : max - 1);

    }
}
