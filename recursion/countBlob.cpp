#include <stdio.h>
// Counting cells in a Blob
// binary image
//  각 픽셀은 background pixel 이거나 혹은 image pixel
//  서로 연결된 image pixel들의 집합을 bloob이라고 부름
//  상하좌우 및 대각방향으로도 연결된 것으로 간주

// 입력 : n * n 2차원 그리드, 하나의 좌표
// 그 점이 속해있는 blob의 크기를 count하라

int offset[8][2] = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

#define BACKGROUND_COLOR 0
#define IMAGE_COLOR 1
#define ALREADY_COUNTED 2

int N = 8;
int grid[][8] = {
    {1, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 1, 0, 0, 1, 0, 0},
    {1, 1, 0, 0, 1, 0, 1, 0},
    {0, 0, 0, 0, 0, 1, 0, 0},
    {0, 1, 0, 1, 0, 1, 0, 0},
    {0, 1, 0, 1, 0, 1, 0, 0},
    {1, 0, 0, 0, 1, 0, 0, 1},
    {0, 1, 1, 0, 0, 1, 1, 1},

};

int countCells(int x, int y)
{
    if (x < 0 || x >= N || y < 0 || y >= N)
        return 0;
    else if (grid[x][y] != IMAGE_COLOR)
        return 0;
    else
    {
        grid[x][y] = ALREADY_COUNTED;
        return 1 + countCells(x - 1, y) + countCells(x - 1, y + 1) + countCells(x, y + 1) + countCells(x + 1, y + 1) + countCells(x + 1, y) + countCells(x + 1, y - 1) + countCells(x, y - 1) + countCells(x - 1, y - 1);
    }
}

int main()
{
    printf("%d\n", countCells(3, 5));
}
