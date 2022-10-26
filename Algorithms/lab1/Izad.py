def sort_trains(arr):
    res = []
    dock = []
    train = 1
    flag = False
    for i in arr:
        if len(dock) > 0:
            if i > dock[-1]:
                flag = True
        dock.append(i)
        res.append("1 1")
        for i in range(len(dock)):
            if dock[-1] == train:
                res.append("2 1")
                train += 1
                dock.pop()

    if flag == True:
        print(0)
    else:
        for i in range(len(res)):
            print(res[i])


n = int(input())
arr = list(map(int, input().split()))
sort_trains(arr)


