// 배낭 채우기
//[프로그래밍 과제] 배낭채우기(knapsack) 문제는 다음과 같이 정의된다.
// N<=16 개의 아이템(item)이 있다. 각 아이템은 가격과 무게가 정해져 있다.
// w0, w1, w2, ... , wn-1을 아이템의 무게라고 하고 을 각 아이템의
// v0, v1, v2, ... , vn-1가격이라고 하자. 배낭의 W용량은 이다. N개의 아이템들 중에서 무게의
// 총량이 W를 초과하지 않으면서 가격의 합이 최대가 되는 부분집합을 찾아
// 서 가격의 최대 합을 출력하는 프로그램을 작성하라.
#include <stdio.h>

int n;
int wmax;
int vmax = 0;
int w[17];
int v[17];
bool included[17] = {0};

void knapsack(int k)
{
    int sumW = 0, sumV = 0;

    if (k == n)
    {
        for (int i = 0; i < n; i++)
        {
            if (included[i] == 1)
            {
                sumV += v[i];
                sumW += w[i];
            }
        }
        if (sumW <= wmax)
        {
            if (sumV >= vmax)
            {
                vmax = sumV;
            }
        }
    }
    else
    {
        included[k] = 1;
        knapsack(k + 1);
        included[k] = 0;
        knapsack(k + 1);
    }
}

int main()
{
    FILE *fp;

    fp = fopen("input.txt", "r");
    fscanf(fp, "%d %d", &n, &wmax);

    for (int i = 0; i < n; i++)
    {
        fscanf(fp, "%d", &w[i]);
    }
    for (int i = 0; i < n; i++)
    {
        fscanf(fp, "%d", &v[i]);
    }

    knapsack(0);
    printf("%d", vmax);
}
