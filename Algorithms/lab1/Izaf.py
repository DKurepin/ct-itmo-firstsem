n = int(input())
arr = list(map(int, input().split()))
res = []
dock = []
train = 1

for i in range(len(arr)):
    if len(dock) > 0:
        if i > dock[-1]:
            print("0")
    dock.append(i)
    res.append("1 1")
    for i in range(len(dock)):
        if dock[-1] == train:
            res.append("2 1")
            train += 1
            dock.pop()
print(*res)
            

