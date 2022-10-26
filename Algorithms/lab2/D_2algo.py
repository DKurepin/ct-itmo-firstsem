r = open("input.txt", "r")
n, m = map(int, r.readline().split())
arr = []
for i in range(n):
    up = list(map(int, r.readline().split()))
    arr.append(up)
r.close()

for i in range(n):
    for j in range(m):
        Max = 0
        if i == 0:
            if j == 0:
                Max = 0
            else:
                Max = arr[i][j-1]
        else:
            if j == 0:
                Max = arr[i-1][j]
            else:
                if arr[i-1][j] > arr[i][j-1]:
                    Max = arr[i-1][j]
                else:
                    Max = arr[i][j-1]
        arr[i][j] += Max
p = n - 1
k = m - 1
res = []
while (i > 0 or j > 0):
    if i == 0:
        j -= 1
        res.append('R')
    elif j == 0:
        i -= 1
        res.append('D')
    else:
        if arr[i-1][j] > arr[i][j-1]:
            i -= 1
            res.append('D')
        else:
            j -= 1
            res.append('R')
g = open("output.txt", "w")
g.writelines(str(arr[n-1][m-1]) + '\n')
for i in range(len(res) - 1, -1, -1):
    g.write(res[i])
g.close()
