n, m = map(int, input().split())
a = [0] * n
dlina = [1] * n
exp = [0] * n
clan = []

def find(Set):
    if a[Set] == Set:
        return Set
    else:
        a[Set] = find(a[Set])
        return s[Set]

def unite(set1, set2):
    x = find(set1)
    y = find(set2)
    if x != y:
        if dlina[x] > dlina[y]:
            x, y = y, x
        a[x] = y
        dlina[y] += dlina[x]

        clan.append(clan[y],clan[x],clan[x])

        
for i in range(n):
    a[i] = i
    clan.append(i)

    for i in range(m):
        s = list(map(int, input().split()))
        if s[0] == "join":
            unite(s[1]-1, s[2]-1)
        elif s == "add":
            x, y = map(int, input().split())
            for i in range(len(clan)):
                clan[find(x-1)]
                exp[i] += y
        else:
            x = int(input())
            print(exp[x-1])
    n = int(input())
    
