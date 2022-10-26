str = input()
stack = []
check = True
for i in str:
    if i in '({[':
        stack.append(i)
    elif i in ')]}':
        if not stack:
            check = False
            break
        opens = stack.pop()
        if opens == '(' and i == ')':
            continue
        if opens == '[' and i == ']':
            continue
        if opens == '{' and i == '}':
            continue
        check = False
        break
if check and len(stack) == 0:
    print("YES")
else:
    print("NO")
        
        
