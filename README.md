# Remote-Procedure-Call
Develop a client/server version. A simulation of Remote Procedure Call communication

The server will be multithreaded. The main server's thread takes care of the connection requests. The spawned server-threads will carry out the extended rendezvous with the clients.

On the client side, create the different types of client threads that will execute concurrently. These clients will ask the main server's thread to establish a connection.

When the connection is accepted by the server, the main server thread will create another "client helper" thread that will carry out the two-way communication with the client thread. The client will ask the corresponding "client helper" thread to execute methods sequentially. Before each method can be executed, it will send the server a message.

Test the solutions by deploying the client site in one bird and the server site in a different bird.
When testing the program, we can remotely connect only on one bird, then have the clients running on one window and the server site on a separate window.
