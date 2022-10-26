def check_mid(mid, arr, n, k):
    counter = 0
    Sum = 0
    for i in range(n):
        if arr[i] > mid:
            return False
        Sum += arr[i]
        if Sum > mid:
            counter += 1
            Sum = arr[i]
    counter += 1
    if counter <= k:
        return True
    return False

def div(arr, n, k):
    first = max(arr)
    last = 0

    for i in range(n):
        last += arr[i]
    answer = 0
    while first <= last:
        mid = (first + last) // 2
        if check_mid(mid, arr, n, k):
            answer = mid
            last = mid - 1
        else:
            first = mid + 1
    return answer
        
n, k = map(int, input().split())
arr = list(map(int, input().split()))
print(div(arr, n, k))
