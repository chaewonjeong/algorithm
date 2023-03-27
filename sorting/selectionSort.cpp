#include <stdio.h>

// selection sort

void selection_sort(int arr[], int n)
{
    for (int i = n - 1; i > 0; i--)
    {
        int max_idx = i;
        for (int j = 0; j < i; j++)
        {
            if (arr[j] > arr[max_idx])
            {
                max_idx = j;
            }
        }
        int temp = arr[i];
        arr[i] = arr[max_idx];
        arr[max_idx] = temp;
    }
}

int main()
{
    int arr[] = {29, 10, 14, 37, 13};
    int n = sizeof(arr) / sizeof(arr[0]);

    selection_sort(arr, n);

    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}