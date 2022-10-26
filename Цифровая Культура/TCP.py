import socket

sock = socket.socket()
sock.connect(('10.8.0.1', 1234))
for i in range(4):
    line = sock.recv(100)
    line = line[:len(line)-1]
    print(line)

lineCounter = 0       
while True:      
    line = sock.recv(100)
    line = line[:len(line)-1]
    print(line)
    if lineCounter == 119:
        break
    if lineCounter % 2 == 0:
        sock.send(str(eval(line)).encode())
        print(eval(line))
    lineCounter += 1
    
line = sock.recv(100)
line = line[:len(line)-1]
print(line)
