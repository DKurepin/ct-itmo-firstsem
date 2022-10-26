n, k = map(int, input().split())
res = []
for i in range(k ** n):
    for j in range(n, 0, -1):
        l = i // k ** j
        if l % 2 == 0:
            res.append(i // k ** (j - 1) % k)
        else:
            res.append(k - (i // k ** (j - 1)) % k - 1)
for i in range(len(res)-1):
    print(str(res[i])+str(res[i+1]))
