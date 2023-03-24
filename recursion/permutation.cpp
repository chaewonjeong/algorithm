#include <stdio.h>
// permutation
// 임이의 집합 data에 대해서 원소들의 모든 가능한 순열을 출력하라.
char data[4] = {'a', 'b', 'c', 'd'};
int n = sizeof(data) / sizeof(data[0]);

void swap(char data[], int k, int i)
{
    int tmp = data[k];
    data[k] = data[i];
    data[i] = tmp;
}

void permutation(int k)
{
    if (k == n)
    {
        for (int i = 0; i < n; i++)
        {
            printf("%c", data[i]);
        }
        printf("\n");
        return;
    }
    // 리커젼에 들어가기 전과 후에 데이터의 동일성이 유지되도록 하라.
    // recursion이 데이터를 변경할 때는 매우 조심해야한다.
    // 호출 전후에 데이터가 변경되지 않고 유지되도록 하는게 좋다.
    for (int i = k; i < n; i++)
    {
        swap(data, k, i);
        permutation(k + 1);
        swap(data, k, i);
        // Mission : data[0..k-1]을 prefix로 하고,
        // data[k..n]으로 만들 수 있는 모든 순열을 프린트하되,
        // 배열 data에 저장된 값들의 순서는 그대로 유지한다.
    }
}

int main()
{
    permutation(0);
}