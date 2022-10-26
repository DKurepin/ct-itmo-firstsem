from collections import deque

n = int(input())
deq = deque()
MinDeq = deque()
for i in range(n):
    line = input()
    if line[0] == "+":
        nums = int(line[2:])
        deq.append(nums)
        if len(MinDeq) == 0:
            MinDeq.append(nums)
        else:
            while len(MinDeq) > 0 and MinDeq[-1] > nums:
                MinDeq.pop()
            MinDeq.append(nums)
        if len(MinDeq) != 0:
            print(MinDeq[0])
        else:
            print("-1")
    if line[0] == "-":
        if len(deq) > 0:
            if deq[0] == MinDeq[0]:
                MinDeq.popleft()
            deq.popleft()
            if len(deq) > 0:
                print(MinDeq[0])
            else:
                print("-1")
        else:
            print("-1")

            
            
                
