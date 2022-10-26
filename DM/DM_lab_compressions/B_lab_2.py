def BWT(n, result):
    for i in range(1, len(n)):
        n = n[1:len(n)] + n[0]
        result.append(n)
    result.sort()
    
    for i in range(len(result)):
        print(result[i][len(n)-1:len(n)], end = '')

n = input()
result = [n]
BWT(n, result)


    
    
