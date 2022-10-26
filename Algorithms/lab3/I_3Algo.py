def simp(n):
    res = []
    step = 2
    while (step ** 2) < (n+1):
        if n % step == 0:
            res.append(step)
            n = n // step
        else:
            step += 1
    if n >= 1:
        res.append(n)
    print(*res)
n = int(input())
simp(n)

        
    
