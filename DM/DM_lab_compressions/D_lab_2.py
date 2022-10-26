def MTF(n,arr):
    abc = "abcdefghijklmnopqrstuvwxyz"
    for i in n:
        result = abc.index(i)
        arr.append(result+1)
        abc = abc[result] + abc[:result] + abc[(result+1):]
        #print(abc)
    return arr
n = input()
arr = []
MTF(n,arr)
print(*arr)


    
    
