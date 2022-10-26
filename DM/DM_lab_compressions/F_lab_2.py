n = int(input())         
arr = list(map(int, input().split()))
abc = list("abcdefghijklmnopqrstuvwxyz")
result = []
result.append(abc[arr[0]])
dic = abc[arr[0]]
t = ""

for i in range(1, len(arr)):
    if arr[i] in range(len(abc)):
        t = abc[arr[i]]
        
    if arr[i] == len(abc):
        t = dic + dic[0]
         
    abc.append(dic + t[0])
    dic = t
    result.append(t)
print(*result, sep = "")

'''def LZW_decoding(arr, abc):
    result = []
    result.append(abc[arr[0]])
    dic = abc[arr[0]]
    t = ""

    for i in range(1, len(arr)):
        if arr[i] in range(len(abc)):
            t = abc[arr[i]]
            
        if arr[i] == len(abc):
            t = dic + dic[0]
             
        abc.append(dic + t[0])
        dic = t
        result.append(t)
    print(*result, sep = "")

n = int(input())         
arr = list(map(int, input().split()))
abc = list("abcdefghijklmnopqrstuvwxyz")
LZW_decoding(arr, abc)'''
