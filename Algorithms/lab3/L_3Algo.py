from math import gcd

def check_gcd(a, b):
    global x
    if gcd(a, b) == x:
        return True
    else:
        return False
    
def DK(x, y):
    mul = x * y
    arr = []
    for i in range(x, int(mul**(1/2))+1, x):
        if mul % i == 0 and check_gcd(i, mul//i) == True:
            arr.append([i, mul//i])
    return arr

x, y = map(int, input().split())
if y == x:
    print(x, x)
else:
    arr = []
    arr = DK(x,y)
    for i in range(len(arr)):
        print(*arr[i])
    for i in range(len(arr)-1,-1,-1):
        if check_gcd(arr[i][1],arr[i][0]) == True:
            print(arr[i][1],arr[i][0])
