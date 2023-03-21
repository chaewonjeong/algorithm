#include <stdio.h>

// 순환적 알고리즘의 설계

// 이진탐색

int binarySearch(int arr[], int n, int target)
{
    int begin = 0, end = n - 1;

    while (begin <= end)
    {
        int middle = (begin + end) / 2;

        if (arr[middle] == target)
        {
            return middle;
        }
        else if (arr[middle] > target)
        {
            end = middle - 1;
        }
        else
        {
            begin = middle + 1;
        }
    }
    return -1;
}

// 암시적인 매개변수를 최대한 명시적으로 드러낼 것!
int binarySearchRecursion(int arr[], int target, int begin, int end)
{
    if (begin > end)
    {
        return -1;
    }
    else
    {
        int middle = (begin + end) / 2;
        if (middle == target)
            return middle;
        else if (arr[middle] > target)
        {
            return binarySearchRecursion(arr, target, begin, middle - 1);
        }
        else
        {
            return binarySearchRecursion(arr, target, middle + 1, end);
        }
    }
}

int main()
{
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

    int target;

    scanf("%d", &target);

    printf("%d\n", binarySearchRecursion(arr, target, 0, 8));
}