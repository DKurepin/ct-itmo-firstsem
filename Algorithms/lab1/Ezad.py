n = int(input())
arr = list(map(int, input().split()))


check = True

for i in range(len(arr)):
    left = (2 * i + 1)
    right = ((2 * i) + 2)
    if left < n:
        if arr[i] < arr[left]:
            continue
        else:
            check = False
            break
    if right < n:
        if arr[i] < arr[right]:
            continue
        else:
            check = False
            break
    
if check == True:
    print("YES")
else:
    print("NO")
        
    
