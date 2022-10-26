def bin_vec(r, i, n):
    global counter
    global res
    if i == n:
        counter += 1
        res.append(r)
        
    else:
        i += 1
        bin_vec(r + '0', i, n)
        if r[len(r)-1] != '1':
            bin_vec(r + '1', i, n)

n = int(input())
counter = 0
res = []
bin_vec("0", 1, n)
bin_vec("1", 1, n)
print(counter)
for i in range(len(res)):
    print(res[i])
