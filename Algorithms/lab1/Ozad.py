import math

C = float(input())
e = 1.0e-10
sq = math.sqrt(C)
x = math.sqrt(C - sq)
while abs(x - sq) > e:
    sq = x
    x = math.sqrt(C - math.sqrt(sq))
print(x)
