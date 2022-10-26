r = open("input.txt")
n = int(r.read())
r.close()
g = open("output.txt", "w")
if n < 1:
    g.write(str(0))
if n == 1:
    g.write(str(2))
if n > 1:
    F = [0] * n
    F[0] = 2
    F[1] = 3
    for i in range(2, n):
        F[i] = F[i - 2] + F[i - 1]
        print(F[i])
    g.write(str(F[-1]))
g.close()

    
