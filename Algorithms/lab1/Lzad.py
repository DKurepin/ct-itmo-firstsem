import random
import math

def quick_sort(mas):
    if len(mas) <= 1:
        return mas
    else:
        right = []
        left = []
        n = []
        x = random.randint(0, len(mas) - 1)
        for i in range(len(mas)):
            if mas[i] < mas[x]:
                left.append(mas[i])
            if mas[i] > mas[x]:
                right.append(mas[i])
            if mas[i] == mas[x]:
                n.append(mas[i])
        mas = quick_sort(left) + n + quick_sort(right)
        return mas

n = int(input())
arr = list(map(int, input().split()))
otr = int(input())
arr = quick_sort(arr)
result = []

def bin_sort(arr, ind):
    left = -1
    right = len(arr)
    while (left + 1 < right):
        mid = (left + right) // 2
        if arr[mid] <= ind:
            left = mid
        else:
            right = mid
    return left

for i in range(otr):
    l, r = map(int, input().split())
    result.append(bin_sort(arr, r) - bin_sort(arr, l - 1))
print(*result)


    
    

        


