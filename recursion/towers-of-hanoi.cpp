#include <stdio.h>

// Towers of Hanoi
// 귀납적으로 가능하다.

// How many movements?
// T(n)을 n개의 디스크르 L에서 R로 옮길 때 필요한 movements의 횟수라고 하자.
// T(1) = 1
// T(n) = T(n - 1) + 1 + T(n-1) = 2T(n-1) + 1,  (n>1인 경우)
// 점화식을 풀어보면 T(n) = 2^n - 1

void showMoves(int n, char start, char dest, char temp)
{

    if (n == 1)
        printf("move disk 1 from peg %c to peg %c\n", start, dest);
    else
    {
        showMoves(n - 1, start, temp, dest);
        printf("move disk %d from peg %c to peg %c\n", n, start, dest);
        showMoves(n - 1, temp, dest, start);
    }
}

int main()
{
    int n;
    scanf("%d", &n);

    showMoves(n, 'L', 'R', 'M');
}