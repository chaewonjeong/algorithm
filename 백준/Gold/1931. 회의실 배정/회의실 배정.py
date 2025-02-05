import sys


n = int(sys.stdin.readline())


data = []

for i in range(n):
    data.append(tuple(map(int, sys.stdin.readline().split())))

data.sort()

result = [[2**31-1,2**31-1]]

for a, b in data:
    if result[-1][1] <= a:
        result.append((a,b))
    elif result[-1][1] > b:
        result.pop()
        result.append((a,b))

print(len(result))
