import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        
        int n = maps.length;
        int m = maps[0].length;
        
        int visited[][] = new int[n][m];
        
        Queue<int[]> queue = new ArrayDeque<>();
        
        
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            if(row == n-1 && col == m-1){
                return visited[row][col];
            }
            
            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                   && maps[newRow][newCol] == 1 && visited[newRow][newCol] == 0){
                    visited[newRow][newCol] = visited[row][col] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return -1;
        
    }
}