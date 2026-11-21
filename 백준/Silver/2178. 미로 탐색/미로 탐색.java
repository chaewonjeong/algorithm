import java.util.*;
import java.io.*;

public class Main {
    static int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];

        for(int i = 0; i < n;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                board[i][j] = chars[j]-'0';
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        dist[0][0] = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if (row == n - 1 && col == m - 1) {
                System.out.println(dist[row][col]);
                return;
            }

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >=0 && newRow < n && newCol >= 0 && newCol < m){
                    if(board[newRow][newCol] == 1 && dist[newRow][newCol] == 0){
                        dist[newRow][newCol] = dist[row][col] + 1;
                        queue.add(new int[]{newRow,newCol});
                    }
                }
            }
        }
        System.out.println(dist[n-1][m-1]);

    }
}
