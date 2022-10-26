def F(p, i, n, res):
    if i == n:
        res.append(p)
        
    else:
        i += 1
        F(p + '0', i, n, res)
        F(p + '1', i, n, res)



n = int(input())
res = []
F("", 0, n, res)
for i in range(len(res)):
    print(res[i])
