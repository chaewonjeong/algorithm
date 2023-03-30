#include <stdio.h>

// Insertion Sort

void insertionSort(int arr[], int n)
{
    for (int i = 1; i < n; i++)
    {
        int tmp = arr[i];
        int j;
        for (j = i - 1; j >= 0 && arr[j] > tmp; j--)
        {
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = tmp;
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

    insertionSort(arr, n);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}