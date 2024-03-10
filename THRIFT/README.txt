
********************************************
SPRING 2024: 5105 Thrift Example:
Instructor: Anand Tripathi
*******************************************

Here are two example services implemented using Thrift with Java.
Both services and their client programs are in Java.

*************
Example 1:  KeyValueStorage example implements  key-value storage service in Java.
************

***********
Example 2:  MultiplicationService implements are service to implement multiplication of two integers.
In this example, the file multipilication.thrift defines three interface methods:
  ping, helo, and multiply
  hello is defined with "oneway" modifier, i.e. the client does not wait for the response.

This example illustrates service implementation in three ways, but the code differences are quite minor: 
    1. Simple single threaded server, 
    2. Single threaded server without using TFramedTrasnport  
    3. Thread pool based server  

SimpleServer:
  The server is implemented as single threaded.
  The transport protocol used is TFramedTransport

SimpleServer-without-FramedTransport
  This service does NOT use framed transport.
  This code is very similar to the code given at
     https://thrift-tutorial.readthedocs.io/en/latest/usage-example.html

ThreadPoolServer
  The server uses a thread pool for servicing requests.
  only two lines are changed in the Server.java  code of SimpleServer.

************************************************

HOW TO RUN THESE EXAMPLES:

1. Go to the specific  example directory
2. Study the "thrift" intrface file.
3. Study the "Handler" code in Java, for example MultiplicationHandler.java
4. Study the code of Server.java and Client.java
5. Start clean by executing "clean.sh"
6. Execute "make.sh"
7. Now execute the Server using the following command, 
   but before doing that make sure that no previously created Server process is running. 
   Kill that process if running.
   java -cp ".:./Thrift13/*" Server&
8. Now run the Client program by using he following command.
    If your client is on the same machien as the server, execute the following command
         java -cp ".:./Thrift13/*" Client
     Otherwise
         java -cp ".:./Thrift13/*" Client serverHostName

**************************************************
