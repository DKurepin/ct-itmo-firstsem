def parking(n):
    if mas[n] != n:
        mas[n] = parking(mas[n])
    return mas[n]

def Next(a,b):
    first = parking(a)
    second = parking(b)
    mas[first] = second

def check(car, n):
    if car + 1 > n:
        Next(car,1)
    else:
        Next(car, car+1)
    
n = int(input())
arr = list(map(int, input().split()))
mas = [i for i in range(n+1)]

for i in range(len(arr)):
    if mas[arr[i]] != arr[i]:
        mas[arr[i]] = parking(mas[arr[i]])
    car = mas[arr[i]]
    print(car, end = " ")
    check(car, n)
    

    

