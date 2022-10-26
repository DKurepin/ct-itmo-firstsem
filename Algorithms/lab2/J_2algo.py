n, m = map(int, input().split())
arr = []
for i in range(n):
    up = list(map(int, input().split()))
    arr.append(up)

Max = 0
for i in range(1,n):
    for j in range(1,m):
        if arr[i][j] == 1:
            arr[i][j] += min(arr[i-1][j], arr[i-1][j-1], arr[i][j-1])
        if arr[i][j] > Max:
            Max = arr[i][j]
print(Max)

            
