def main():
    def psp(kol, res, op, cl):
        if op == kol == cl:
            print(res)
        if op < kol:
            psp(kol, res + '(', op+1, cl)
        if cl < op:
            psp(kol, res + ')', op, cl+1)
            
    n = int(input())
    res = ""
    op = 0
    cl = 0
    psp(n, res, op, cl)
    
if __name__ == '__main__':
    main()
