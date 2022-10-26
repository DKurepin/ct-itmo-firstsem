
def distance(a, b):
    n, m = len(a), len(b)
    if n > m:
        a, b = b, a
        n, m = m, n
    cur_row = range(n + 1)  
    for i in range(1, m + 1):
        prev_row, cur_row = cur_row, [i] + [0] * n
        for j in range(1, n + 1):
            add, delete, change = prev_row[j] + 1, cur_row[j - 1] + 1, prev_row[j - 1]
            if a[j - 1] != b[i - 1]:
                change += 1
            cur_row[j] = min(add, delete, change)

    return cur_row[n]
a = input()
b = input()
res = distance(a, b)
print(res)
