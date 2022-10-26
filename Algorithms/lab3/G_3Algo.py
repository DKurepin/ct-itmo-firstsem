n, x = map(int, input().split())
h = 0
counter = 0
for i in range(2, n+1):
    for j in range(1, n//2):
        if i % j == 0:
            counter += 1
    if counter == 0:
        h = h * x + i
    counter = 0
print(h)
