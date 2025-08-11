import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());

       int[][] board = new int[n][m];
       int[][] visited = new int[n][m];

       for(int i = 0; i < n; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j < m; j++){
               board[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       int biggest = 0;
       int count = 0;

       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               if(board[i][j] == 1 && visited[i][j] == 0){
                   Queue<int[]> queue = new ArrayDeque<>();
                   queue.add(new int[]{i, j});
                   int area = 1;
                   visited[i][j] = 1;
                   while(!queue.isEmpty()){
                       int[] cur = queue.poll();
                       int row =  cur[0];
                       int col = cur[1];

                       for(int[] dir : dirs){
                           int newRow = row + dir[0];
                           int newCol = col + dir[1];

                           if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                               if(board[newRow][newCol] == 1 && visited[newRow][newCol] == 0){
                                   queue.add(new int[]{newRow, newCol});
                                   area++;
                                   visited[newRow][newCol] = 1;
                               }
                           }

                       }
                   }
                   count++;
                   biggest = Math.max(area, biggest);

               }

           }
       }

        System.out.println(count);
        System.out.println(biggest);


    }
}
