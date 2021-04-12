

# import socket
# from threading import *

# serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# host = "127.0.0.1"
# port = 8888
# print(host)
# print(port)
# serversocket.bind((host, port))


# class client(Thread):
#     def __init__(self, socket, address):
#         Thread.__init__(self)
#         self.sock = socket
#         self.addr = address
#         self.start()

#     def run(self):
#         while 1:
#             print('Client sent:', self.sock.recv(1024).decode())
#             self.sock.send(b'Oi you sent something to me')


# serversocket.listen(5)
# print('server started and listening')
# while 1:
#     clientsocket, address = serversocket.accept()
#     client(clientsocket, address)

#!/usr/bin/env python3

import socket

HOST = '127.0.0.1'  # The server's hostname or IP address
PORT = 8888        # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    # s.sendall(b'Hello, world')
    data = s.recv(1024)

print('Received', repr(data))
