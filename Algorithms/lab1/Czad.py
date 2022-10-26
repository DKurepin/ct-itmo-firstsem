def merge(arr1, arr2):
    arr = []
    global result
    while arr1 and arr2:
        if arr1[-1] <= arr2[-1]:
            arr.append(arr2.pop())
        else:
            arr.append(arr1.pop())
            result += len(arr2)
    arr.reverse()
    return arr1 + arr2 + arr
    
   
    
def merge_sort(arr):
    l = len(arr) // 2
    if l > 0:
        return merge(merge_sort(arr[:l]), merge_sort(arr[l:]))
    else:
        return arr
    
   
n = int(input())
result = 0
arr = list(map(int,input().split()))
merge_sort(arr)
print(result)


