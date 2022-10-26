def corporate(i):
    if p[i] != i:
        p[i] = corporate(p[i])
    return p[i]
    
def simp(i, j):
    a = corporate(i)
    b = corporate(j)

    if a == b:
        return
    if r[a] == r[b]:
        r[a] += 1
    if r[a] < r[b]:
        p[a] = b
    else:
        p[b] = a
        
n, m = map(int, input().split())
Next = [0] * (n+2)
p = [0] * (n+2)
r = [0] * (n+2)
for i in range(n+2):
    Next.append(i+1)
    p.append(i)
    
for i in range(m):
    t1, t2, t3 = map(int, input().split())
    print(t1, t2, t3)

    if t1 == 1:
        simp(t2, t3)
    if t1 == 2:
        arr = []
        one = Next[t2]
        while one <= t3:
            arr.append(t2)
            simp(t2, one)
            t2 = one
            one = Next[t2]
        for i in range(len(arr)-1,-1,-1):
            Next[arr[i]] = Next[Next[arr[i]]]
    if t1 == 3:
        ab = corporate(t2)
        bc = corporate(t3)

        if ab == bc:
            print("YES")
        else:
            print("NO")
