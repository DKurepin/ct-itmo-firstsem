def bin_sort(n,k,arr,req):
    for i in req:
        r = n - 1
        l = 0
        while l < r:
            mid = (l + r) // 2
            if arr[mid] < i:
                l = mid + 1
            else:
                r = mid
            first = abs(arr[l] - i)
            second = abs(arr[l-1] - i)
        if l > 0 and arr[l] != i and second <= first:
            print(arr[l-1])
        else:
            print(arr[l])

n, k = map(int, input().split())
arr = list(map(int, input().split()))
req = list(map(int, input().split()))
bin_sort(n,k,arr,req)
