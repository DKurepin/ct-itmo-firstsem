def count_sort(a):
    mass = []
    for i in range(100+1):
        mass += [0]
    for i in a:
        mass[i] += 1
    j = 0
    for i in range(100+1):
        if mass[i] > 0:
            for k in range(mass[i]):
                a[j] = i
                j += 1
    return a
                
n = int(input())
arr = list(map(int, input().split()))
arr = count_sort(arr)
print(*arr)
