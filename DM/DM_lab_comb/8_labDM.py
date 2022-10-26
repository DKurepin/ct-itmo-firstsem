def conj(arr, n, k, res):
    if k != 1:
        arr[k-1] = arr[k-2]+1
    else:
        arr[0] = 1
    ind = k - 1
    counter = 0
    while arr[0] <= n:
        while arr[ind] <= n:
            if counter != 0:
                for i in range(len(res)-k):
                    res.append(i)
                print(*res)
            for i in range(len(arr)-1):
                res.append(str(arr[i]))
            res.append(arr[len(arr)-1])
            arr[ind] += 1
            counter += 1
        while ind >= 0:
            if arr[ind] >= n + ind - k + 1:
                ind -= 1
            else:
                break
        if ind == -1:
            break
        arr[ind] += 1
        for i in range(ind+1, k):
            arr[i] = arr[i-1] + 1
        ind = k - 1
n, k = map(int, input().split())
arr = []
res = []
for i in range(1, n+1):
    arr.append(i)
conj(arr, n, k, res)
