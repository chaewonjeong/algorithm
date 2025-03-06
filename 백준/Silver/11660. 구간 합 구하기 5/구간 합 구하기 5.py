import sys
input = sys.stdin.readline

n, m = map(int, input().split())
A = []
D = [[0]*(n) for _ in range(n)]

for i in range(n):
    A_row = [int(x) for x in input().split()]
    A.append(A_row)

# 구간합 채우기
D[0][0] = A[0][0]
# 첫줄
for i in range(1, n):
    D[0][i] = D[0][i-1] + A[0][i]
    D[i][0] = D[i-1][0] + A[i][0]

for i in range(1, n):
    for j in range(1, n):
        D[i][j] = D[i-1][j] + D[i][j-1] + A[i][j] - D[i-1][j-1]


for i in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    x1, y1, x2, y2 = x1-1, y1-1, x2-1, y2-1

    if x1 != 0 and y1 != 0:
        result = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1]
    elif x1 == 0 and y1 != 0:
        result = D[x2][y2] - D[x2][y1-1]
    elif x1 != 0 and y1 == 0:
        result = D[x2][y2] - D[x1-1][y2]
    else:
        result = D[x2][y2]

    print(result)
