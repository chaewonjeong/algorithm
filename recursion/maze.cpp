#include <stdio.h>

// Maze(미로찾기)
// 현재 위치에서 출구가 있거나
// 인접한 4개의 셀중 하나에서 출구까지 가는 경로가 있거나

// 현재 위치에서 이미 가본 곳을 다시 지나지 않고 출구까지 가는 경로가 있으려면
//  현재 위치가 출구이거나 혹은
//  이웃한 셀들 중 하나에서 이미 가본 곳을 다시 지나지 않고 출구까지 가는 경로가 있는지 검사

int N = 8;

int maze[][8] = {
    {0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 1, 0, 1, 1, 0, 1},
    {0, 0, 0, 1, 0, 0, 0, 1},
    {0, 1, 0, 0, 1, 1, 0, 0},
    {0, 1, 1, 1, 0, 0, 1, 1},
    {0, 1, 0, 0, 0, 1, 0, 1},
    {0, 0, 0, 1, 0, 0, 0, 1},
    {0, 1, 1, 1, 0, 1, 0, 0},
};

#define PATHWAY_COLOR 0 // white : 지나갈 수 있는 cell
#define WALL_COLOR 1    // blue : 벽
#define BLOCKED_COLOR 2 // red : visited이며 출구까지의 경로상에 있지 않음이 밝혀진 cell
#define PATH_COLOR 3    // green : visited이며 출구로가는 경로가 될  가능성이 있는 cell

bool findMazePath(int x, int y)
{
    if (x < 0 || y < 0 || x >= N || y >= N || maze[x][y] != PATHWAY_COLOR)
        return false;

    else if (x == N - 1 && y == N - 1)
    {
        maze[x][y] = PATH_COLOR;
        return true;
    }
    else
    {
        maze[x][y] = PATH_COLOR; // visited
        if (findMazePath(x - 1, y) || findMazePath(x, y + 1) || findMazePath(x + 1, y) || findMazePath(x, y - 1))
        {
            return true;
        }
        maze[x][y] = BLOCKED_COLOR; // dead end
        return false;
    }
}
void printMaze()
{
    for (int i = 0; i < N; i++)
    {
        {
            for (int j = 0; j < N; j++)
            {
                printf("%d ", maze[i][j]);
            }
            printf("\n");
        }
    }
}

int offset[4][2] = {{-1, 0},
                    {0, 1},
                    {1, 0},
                    {0, -1}};

void printPath(int x, int y)
{
    printf("(%d, %d)\n", x, y);
    if (x == N - 1 && y == N - 1)
        return;

    for (int dir = 0; dir < 4; dir++)
    {
        int x_next = x + offset[dir][0];
        int y_next = y + offset[dir][1];
        if (x_next >= 0 && x_next < N && y_next >= 0 && y_next < N && maze[x_next][y_next] == PATH_COLOR)
        {
            maze[x][y] = BLOCKED_COLOR; // 색칠을 안해주면 무한루프 발생
            printPath(x_next, y_next);
            maze[x][y] = PATH_COLOR;
            return;
        }
    }
    printf("No path.");
    return;
}

int main()
{
    printMaze();
    printf("\n");
    findMazePath(0, 0);
    printf("\n");
    printf("\n");
    printMaze();
    printPath(0, 0);
    printMaze();
}