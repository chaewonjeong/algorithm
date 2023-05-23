def qsort(arr, left, right):
    pl = left
    pr = right
    pivot = arr[(left+right)//2]

    while pl <= pr:
        while arr[pl] < pivot:
            pl += 1
        while arr[pr] > pivot:
            pr -= 1

        if pl <= pr:
            arr[pr], arr[pl] = arr[pl], arr[pr]
            pl += 1
            pr -= 1

    if left < pr:
        qsort(arr, left, pr)
    if pl < right:
        qsort(arr, pl, right)


def quick_sort(arr):
    qsort(arr, 0, len(arr)-1)


list = [3, 56, 123, 3, 55, 33, 4, 12, 56, 44, 427, 45, 32, 8, 76, 10]
print(list)
quick_sort(list)
print(list)
