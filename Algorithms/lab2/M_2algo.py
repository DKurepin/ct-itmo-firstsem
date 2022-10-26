m, n = list(map(int, input().split()))
arr = list(map(int, input().split()))
Sum = sum(arr)
rab = [0] * (Sum + 1)
rab[0] = 1
if n > Sum:
    print("NO")
else:
    for i in range(m):
        mas = []
        for j in range(len(rab)):
            if rab[j] == 1:
                mas.append(j)
        for j in mas:
            rab[j+arr[i]] = 1    
      
    if rab[n] == 1:
        print("YES")
    else:
        print("NO")
        
        
