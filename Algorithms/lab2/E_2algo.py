def s(x):
    return sum([int(i) for i in str(x)])
kol = 0
for i in range(999, 10000):
    if s(i) == 10:
        kol += 1
Sum = kol % 1000000007
print(Sum)
