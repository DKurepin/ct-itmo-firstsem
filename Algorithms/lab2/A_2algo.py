r = open("input.txt")
y = int(r.read())
r.close()
F = [0] * y
F[0] = 1
F[1] = 1
for i in range(1, y):
    F[i] = F[i - 2] + F[i - 1]  
g = open("output.txt", "w")
g.write(str(F[-1]))
g.close()

