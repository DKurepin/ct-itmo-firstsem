def siftUp(arr):
    i = len(arr) - 1
    while arr[i] > arr[(i - 1) // 2] and i != 0:
        (arr[i], arr[(i - 1) // 2]) = (arr[(i-1) // 2], arr[i])
        i = (i - 1) // 2

def siftDown(arr):
    i = 0
    while 2 * i + 1 < len(arr):
        left = 2 * i + 1
        right = 2 * i + 2
        j = left
        if right < len(arr) and arr[right] > arr[left]:
            j = right
        if arr[i] >= arr[j]:
            break
        (arr[i], arr[j]) = (arr[j], arr[i])
        i = j


def out(n, arr):
    for i in range(n):
        com = list(map(int, input().split()))
        if com[0] == 0:
            arr.append(com[1])
            siftUp(arr)
        if com[0] == 1:
            (arr[0], arr[-1]) = (arr[-1], arr[0])
            print(arr.pop())
            siftDown(arr)
        
n = int(input())
arr = []
out(n, arr)
