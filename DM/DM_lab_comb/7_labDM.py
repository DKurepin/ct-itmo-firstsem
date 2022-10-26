def perm(a, ind):
    global res
    if ind == len(a):
        string = ""
        for i in range(len(a)):
            string = string + str(a[i]) + " "
        res.append(string)
    else:
        for i in range(ind, len(a)):
            a[ind], a[i] = a[i] ,a[ind]
            perm(a, ind+1)
            a[ind], a[i] = a[i], a[ind]

    return res
n = int(input())
ind = 0
arr = []
res = []
for i in range(1,n+1):
    arr.append(i)
perm(arr, ind)
res.sort()
for i in range(len(res)):
    print(res[i])


