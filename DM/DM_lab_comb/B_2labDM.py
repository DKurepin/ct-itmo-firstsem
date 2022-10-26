def gray(g, a):
    length = 2 ** a
    if len(g) == length:
        for i in range(len(g)):
            print(g[i])
    else:
        mas = g
        res = []
        for i in range(len(g)-1, -1, -1):
            mas.append(g[i])
        st = ''
        for i in range(len(mas)//2):
            st = '0' + str(mas[i])
            res.append(st)
        k = ''
        for j in range(len(mas)//2, len(mas)):
            k = '1' + str(mas[j])
            res.append(k)
        return gray(res, a)


a = int(input())
g = [0] * 2
g[0] = 0
g[1] = 1
gray(g, a)
