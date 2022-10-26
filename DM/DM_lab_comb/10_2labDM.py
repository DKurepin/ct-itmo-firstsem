def f(s, cur, prev):
    if cur < 0:
        return
    elif cur == 0:
        result.append(s, 0, (len(s)-1),i)
    else:
        for i in range(prev, cur+1):
            f(s + i + "+", cur-i,i)
    print(result)


n = int(input())
res = 1
for i in range(1, n+1):
    res *= i
f("", res, 1)
