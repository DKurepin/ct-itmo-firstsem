def perm(a, ind, k):
    kol = 0
    global res
    if ind == len(a):
        kol += 1
        string = ""
        for i in range(len(a)):
            string = string + str(a[i]) + " "
        res.append(string)
        res.sort()
        if kol == k:
            print(res[k])
            
    else:
        for i in range(ind, len(a)):
            a[ind], a[i] = a[i] ,a[ind]
            perm(a, ind+1, k)
            a[ind], a[i] = a[i], a[ind]

    

n, k = map(int, input().split())
ind = 0
arr = []
res = []
for i in range(1,n+1):
    arr.append(i)
perm(arr, ind, k)



