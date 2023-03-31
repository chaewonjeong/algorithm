#include <stdio.h>

// Merge Sort

// 추가 배열 이용
int tmplist[100];

// i j k 이용

void merge(int arr[], int p, int q, int r)
{
    int i = p, j = q + 1, k = p;
    while (i <= q && j <= r)
    {
        if (arr[i] < arr[j])
        {
            tmplist[k++] = arr[i++];
        }
        else
        {
            tmplist[k++] = arr[j++];
        }
    }
    while (i <= q)
    {
        tmplist[k++] = arr[i++];
    }
    while (j <= r)
    {
        tmplist[k++] = arr[j++];
    }

    for (int i = p; i <= r; i++)
        arr[i] = tmplist[i];
}

void mergeSort(int arr[], int p, int r)
{
    if (p < r)
    {
        int q = (p + r) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
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

    mergeSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}