def partition(arr, p, r):
    i = p-1
    j = p
    x = arr[r]

    while j <= r-1:
        if arr[j] >= x:
            j += 1
        else:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
            j += 1
    arr[i+1], arr[r] = arr[r], arr[i + 1]

    return i+1


def qsort(arr, p, r):
    if p <= r:
        q = partition(arr, p, r)
        qsort(arr, p, q-1)
        qsort(arr, q+1, r)


def quickSort(arr):
    qsort(arr, 0, len(arr)-1)


list = [3, 56, 123, 3, 55, 33, 4, 12, 56, 44, 427, 45, 32, 8, 76, 10]
print(list)
quickSort(list)
print(list)
