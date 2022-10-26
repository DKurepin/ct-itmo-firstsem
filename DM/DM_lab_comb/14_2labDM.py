def perm(a, ind):
    global m
    global res
    global k
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
    kol = -1
    for i in range(len(res)):
        if res[i] == m:
            k.append(kol)
        else:
            kol += 1
    
k = []
res = []    
n = int(input())
mas = list(map(int, input().split()))
m = ""
for i in range(len(mas)):
    m += str(mas[i]) + " "
ind = 0
arr = []
for i in range(1,n+1):
    arr.append(i)
perm(arr, ind)
print(k[0])


