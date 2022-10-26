n = int(input())
arr = []
for i in range(n):
    arr.append(input())
arr.sort()
for j in range(n):
    line = str(arr[j])
    lastID = line.rfind('/')
    counter = 0
    for k in range(len(line)):
        if line[k] == '/':
            counter += 1
    if lastID >= 0:
        print((" ") * (counter * 2) + line[lastID+1:])
    else:
        print(line)
            
    
    
    
