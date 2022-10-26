def prefix(arr, n, m):
    
    prefSum = []
    prefSum.append(arr[0])
    for i in range(1, n):
        prefSum.append(arr[i] + prefSum[i-1])

    for j in range(m):  
        l, r = map(int, input().split())
        r -= 1
        l -= 1
        Right = prefSum[r]
        Left = prefSum[l-1]
        if l <= 0:
            print(Right)
        if l > 0:
            print(Right - Left)

n,m = map(int, input().split())
arr = list(map(int, input().split()))
prefix(arr, n, m)


