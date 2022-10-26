n = int(input())
arr = list(map(int, input().split()))
prev = [0] * (n-1)
d = [0] * n
mest = [0] * n
length = 0

d[0] = -100007
mest[0] = -1
for i in range(1, n):
    d[i] = 100007

def bin_sort(mas, key): 
    left = -1 
    right = len(mas) 
    while right > left + 1: 
        middle = (left + right) // 2 
        if d[middle] > key: 
            right = middle 
        else: 
            left = middle 
    return right
    
for i in range(0,n-1):
    j = bin_sort(d, arr[i])
    if d[j-1] < arr[i] and arr[i] < d[j]:
        d[j] = arr[i]
        mest[j] = i
        prev[i] = mest[j-1]
        length = max(length, j)

res = []
pos = mest[length]
while pos != -1:
    res.append(arr[pos])
    pos = prev[pos]
    
print(len(res))
print(*(reversed(res)))

