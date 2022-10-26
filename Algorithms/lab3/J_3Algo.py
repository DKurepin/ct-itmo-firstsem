from math import sqrt
def fucktorize(n):
    res = []
    while n % 2 == 0:
        res.append(2)
        n = n // 2
    for i in range(3, int(sqrt(n))+1,2):
        while n % i == 0:
            res.append(i)
            n = n // i
    if n != 1:
        res.append(n)
    print(*res)

nums = int(input())
for i in range(nums):
    n = int(input())
    fucktorize(n)
    
