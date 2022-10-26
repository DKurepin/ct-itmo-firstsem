def main():
    def AntiGay(n, g):
        length = 3 ** n
        if n == (3 ** (n-1)):
            for i in range(3):
                print(i)
        else:
            for i in range(length):
                for j in range(3):
                    string = ""
                    num = i
                    for t in range(n):
                        every = num % 3 + j
                        string += str(every % 3)
                        num = num // 3
                    g.append(string)
                print(g[i])
                    
    n = int(input())
    g = []
    AntiGay(n, g)

if __name__ == '__main__':
    main()
