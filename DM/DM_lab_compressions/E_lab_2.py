def LZW_encode(s, t):
    abc = list("abcdefghijklmnopqrstuvwxyz")
    result = []
    for c in s:
        if c+t in abc:
            t = c+t
        else:
            result.append(abc.index(t))
            abc.append(c+t)
            t = c
    result.append(abc.index(t))
    print(*result)

           
s = input()
t = ""
LZW_encode(s, t)

