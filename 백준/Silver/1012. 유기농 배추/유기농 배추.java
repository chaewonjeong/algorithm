import java.util.*;

public class Main {
	public static void main(String args[]){
		// 이거 x, y 헷갈리지 않도록...
		// T : 테스트 케이스
		// 배추밭 가로길이 : M
		// 배추밭 세로길이 : N
		// 배추 개수 : K
		// 이어지는 K줄에는 배추의 위치가
		// (X,Y)로 주어지는데 
		// X - M (가로) / Y - N (세로)
		
		int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++){
			int answer = 0;
			
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
		
			int[][] maps = new int[N][M];
			int[][] visited = new int[N][M];
		
			for(int i = 0; i < K; i++){
				int col = sc.nextInt();
				int row = sc.nextInt();
				maps[row][col] = 1;
			}
		
			for(int i = 0; i < N; i++){
				for(int j = 0; j < M; j++){
					if(maps[i][j] == 1 && visited[i][j] == 0){
						Queue<int[]> queue = new ArrayDeque<>();
						visited[i][j] = 1;
						queue.add(new int[]{i,j});
						
						while(!queue.isEmpty()){
							int[] current = queue.poll();
							int row = current[0];
							int col = current[1];
							
							for(int[] dir : dirs){
								int newRow = row + dir[0];
								int newCol = col + dir[1];
								if(newRow >=0 && newRow < N && newCol >= 0 && newCol < M
									&& maps[newRow][newCol] == 1 && visited[newRow][newCol] == 0){
									visited[newRow][newCol] = 1;
									queue.add(new int[]{newRow,newCol});
								}							
								
							}	
						}
						answer++;
					}
				}
			}
			System.out.println(answer);
		}		
	}
}
                                              