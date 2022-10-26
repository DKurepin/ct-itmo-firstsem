n, m = map(int, input().split())
arr = list(map(int, input().split()))
res = []
for i in range(len(arr)):
    if arr[i] % m == 0 and arr[i] % arr[i-1] != 0:
        res.append(arr[i])
if len(res) <= 1:
    print(-1)
else: 
    print(len(res))
    print(*res)
    

