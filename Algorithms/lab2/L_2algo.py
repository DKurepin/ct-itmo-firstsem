def bin_sort(res):
    global d
    left = -1 
    right = len(d) 
    while right > left + 1: 
        middle = (left + right) // 2 
        if d[middle] > res: 
            right = middle 
        else: 
            left = middle 
    return right

n, a, k, b, m = map(int, input().split())
res = [0] * n
res[0] = a
Len = 0
d = [100000000] * (n+1)
d[0] = -100000000

for i in range(n):
    if i == 0:
        res[i] = a
    else:
        res[i] = (k * res[i-1] + b) % m
    j = bin_sort(res[i])
    if d[j-1] < res[i] and res[i] < d[j]:
        d[j] = res[i]
        Len = max(Len, j)
print(Len)
print(*res)
