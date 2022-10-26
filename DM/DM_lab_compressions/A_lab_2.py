n = int(input())
arr = list(map(int, input().split()))
arr.sort()
result = 0
dope = []

def pop(arr):
    arr.pop(0)
    arr.pop(0)
    
for i in range(1, len(arr)):
    per = arr[0] + arr[1]
    pop(arr)
    arr.append(per)
    dope.append(per)
    arr.sort()
    
for i in range(len(dope)):
    result += dope[i]
print(result)
        
