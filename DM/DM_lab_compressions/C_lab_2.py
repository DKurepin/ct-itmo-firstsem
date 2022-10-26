def rev_BWT(n, result):
    for i in range(len(n)):
        for j in range(len(n)):
            result[j] = n[j] + result[j]
        result.sort()
    print(result[0])

n = input()
result = [''] * len(n)
rev_BWT(n, result)

