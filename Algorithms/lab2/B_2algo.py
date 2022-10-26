f = open("input.txt", "r")
n, k = map(int, f.readline().split())
arr = list(map(int, f.readline().split()))
hops = [0] * n
arr.append(0)
g = open("output.txt", "w")
    
for i in range(1, n):
    lID = max(0, i - k)
    hops[i] = arr[i - 1] + max(hops[lID:i])
g.write(str(hops[-1]) + "\n")

i = len(hops)
count = [str(i)]
while i > 1:
    lID = max(0, i - k - 1)
    rID = max(0, i - 1)
    path = hops[lID:rID]
    path = path[::-1]
    lap = max((x, -i) for i, x in enumerate(path))[1]
    step = -lap
    i -= (step + 1)
    count.append(str(i))
    
res = ""
for i in range(len(count[::-1])-1,-1,-1):
    res = res + count[i] + " "
    
g.write(str(len(count)-1) + "\n")
g.write(str(res) + "\n")
g.close()
