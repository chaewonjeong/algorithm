import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][][] price;
    static int size;
    static final int INF = 0x3f3f3f3f;
    static int minPrice = INF;

    static void bfs(int[][] board, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c, -1});


        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dir = cur[2];

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newRow < size && newCol >= 0 && newCol < size
                        && board[newRow][newCol] == 0) {
                    int newPrice;

                    if (dir == -1 || dir == i) {
                        if (dir == -1) {
                            newPrice = price[row][col][i] + 100; // 처음 출발
                        } else {
                            newPrice = price[row][col][dir] + 100; // 같은 방향으로 직선 이동
                        }
                    } else {
                        newPrice = price[row][col][dir] + 600; // 코너(방향 전환)
                    }

                    if (price[newRow][newCol][i] > newPrice) {
                        price[newRow][newCol][i] = newPrice;
                        queue.add(new int[]{newRow, newCol, i});
                    }
                }
            }

        }

    }

    public int solution(int[][] board) {
        size = board.length;
        price = new int[size][size][4]; // 0:상 / 1:하 / 2:좌 / 3:우

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                price[i][j][0] = INF;
                price[i][j][1] = INF;
                price[i][j][2] = INF;
                price[i][j][3] = INF;
            }
        }

        price[0][0][0] = 0;
        price[0][0][1] = 0;
        price[0][0][2] = 0;
        price[0][0][3] = 0;

        bfs(board, 0, 0);
        int answer = INF;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, price[size - 1][size - 1][i]);
        }
        return answer;
    }
}