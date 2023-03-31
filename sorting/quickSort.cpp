#include <stdio.h>

// quick sort

// partition function : 피봇의 위치 반환
int partition(int arr[], int p, int r)
{
    int x = arr[r]; // pivot
    int i = p - 1;
    int temp;

    for (int j = p; j <= r; j++)
    {
        if (arr[j] < x)
        { // 작을때만 바꾼다. j가 r까지와서 pivot값을 가리켜도 변하는거 없음
            i++;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    temp = arr[i + 1];
    arr[i + 1] = arr[r];
    arr[r] = temp;

    return i + 1;
}

void quickSort(int arr[], int p, int r)
{
    if (p < r)
    {
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1); // 피봇 기준 왼쪽 부분배열 정렬
        quickSort(arr, q + 1, r); // 피봇 기준 오른쪽 부분배열 정렬
    }
}

int main()
{
    int arr[] = {29, 10, 14, 37, 13};
    int n = sizeof(arr) / sizeof(arr[0]);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    quickSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}