#include <stdio.h>

// 2-sum
// data[]에는 n개의 정수가 오름차순으로 정렬되어 있다.

// 배열 data에 합이 k가 되는 쌍이 존재하는지 검사한다.
bool twoSum(int data[], int n, int k)
{
    int begin = 0, end = n - 1;
    while (begin < end)
    {
        if (data[begin] + data[end] == k)
        {
            return true;
        }
        if (data[begin] + data[end] > k)
        {
            end--;
        }
        else
        {
            begin++;
        }
    }
    return false;
}

bool twoSumRecursion(int data[], int n)
{
}