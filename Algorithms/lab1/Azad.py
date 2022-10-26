import random

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

a = int(input())
arr = list(map(int, input().split()))
arr = quick_sort(arr)
print(*arr)
