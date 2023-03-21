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

// 순환적 알고리즘의 설계
// 같은 알고리즘을 반복문을 사용하여 표현 할때와 recursion으로 표현할때의 signiture는 차이가 있다.

// recursion
// begin, end : 내가 추가적으로 검사해봐야할 범위
bool twoSumRecursion(int data[], int begin, int end, int k)
{
    if (begin >= end)
        return false;
    else
    {
        if (data[begin] + data[end] == k)
        {
            return true;
        }
        else if (data[begin] + data[end] < k)
        {
            return twoSumRecursion(data, begin + 1, end, k);
        }
        else
        {
            return twoSumRecursion(data, begin, end - 1, k);
        }
    }
}