r = open("knight2.in", "r")
n, m = map(int, r.readline().split())
r.close
arr = [[0] * (m + 1) for i in range(n+1)]
arr[1][1] = 1
for i in range(2, n + 1):
    for j in range(2, m + 1):
        arr[i][j] = arr[i-1][j-2] + arr[i-2][j-1]
g = open("knight2.out", "w")
g.write(str(arr[n][m]))
g.close()
