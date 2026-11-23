import java.util.*;
import java.io.*;

public class Main {

    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());



        for(int c = 0; c < testCase; c++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            boolean flag = false;


            char[][] board = new char[n][m];
            int[][] visited = new int[n][m];

            Queue<int[]> queue = new ArrayDeque<>();

            int[] start = null;

            for(int i = 0; i < n; i++){
                String line = br.readLine();
                for(int j = 0; j < m; j++){
                    board[i][j] = line.charAt(j);
                    if (line.charAt(j) == '@'){
                        visited[i][j] = 1;
                        start = new int[] {i,j,0};
                    } else if(line.charAt(j) == '*') {
                        queue.add(new int[] {i,j,1}); // 불 = 1
                    }
                }
            }
            queue.add(start);

            while(!queue.isEmpty()){
                int[] cur = queue.poll();;

                if(cur[2] == 0){
                    int row = cur[0];
                    int col = cur[1];

                    if(row == 0 || row == n-1 || col == 0 || col == m-1){
                        System.out.println(visited[row][col]);
                        flag = true;
                        break;
                    }

                    for(int[] dir : dirs){
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                            if(board[newRow][newCol] == '.' && visited[newRow][newCol] == 0){
                                visited[newRow][newCol] = visited[row][col] + 1;
                                queue.add(new int[]{newRow,newCol,0});
                            }
                        }
                    }
                } else if (cur[2] == 1){
                    int row = cur[0];
                    int col = cur[1];

                    for(int[] dir : dirs){
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                            if(board[newRow][newCol] == '.' || board[newRow][newCol] == '@'){
                                board[newRow][newCol] = '*';
                                queue.add(new int[]{newRow,newCol,1});
                            }
                        }
                    }
                }

            }

            if(!flag){
                System.out.println("IMPOSSIBLE");
            }

        }

    }

}
