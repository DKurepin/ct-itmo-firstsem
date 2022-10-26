def chikibriki(n,x,y,rBound,lBound):
    
    while rBound - lBound > 1:
        Mid = (rBound + lBound) // 2
        comb = Mid // x + Mid // y

        if (n - 1) <= comb:
            rBound = Mid
        else:
            lBound  = Mid

    result = Min + lBound + 1
    print(result)


n, x, y = map(int,input().split())
Min = min(x, y)
if n == 1:
    result = Min
    print(result)
if n > 1:
    rBound = (x + y - Min + 1) * n
    lBound = 0
    chikibriki(n, x, y, rBound, lBound)
