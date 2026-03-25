Full Basic Notes Fundamentals:
```
In client-server architecture, the client sends a request which is resolved via DNS into an IP address. A TCP connection is established using a 3-way handshake, and HTTP requests are sent over this connection using sockets. The server processes the request (static or dynamic) and sends a response back. To handle multiple requests efficiently, servers use thread pools or asynchronous models, while JavaScript uses an event loop to handle concurrency despite being single-threaded.
```

1️⃣ 🧠 Server (Core Concept)
✅ Definition
A server is a software (or hardware) system that:
Receives requests from clients(Static or Dynamic) and provides resources, data, or services over a network.

📦 Types of Content
🔹 Static Content
Pre-built files
Same for all users
Examples:
HTML, CSS, JS, Images

🔹 Dynamic Content
Generated at runtime
Depends on:
User input
Business logic
Database
Examples:
Login system
Dashboard
Recommendations

2️⃣ 🌐 Web Server vs Application Server
🔹 Web Server
Handles HTTP requests
Serves static content
Fast, no heavy logic
Examples:
Apache HTTP Server
Nginx


🔹 Application Server
Runs business logic
Communicates with DB
Generates dynamic response
Examples:
Node.js
Django

🎯 One-Line Difference
Web server serves static content, while application server handles logic and dynamic content.

3️⃣ 🔁 Client–Server Architecture Flow
✅ Step-by-Step Flow
User enters URL
DNS resolves domain → IP
Domain Name System
Client connects using
Transmission Control Protocol
TCP 3-way handshake happens
HTTP request sent
Hypertext Transfer Protocol
Server processes request
Response sent (HTML/JSON)
Browser renders UI

4️⃣ 🔐 TCP 3-Way Handshake

Purpose:
 To establish a reliable connection between client and server before sending data.
TCP is connection-oriented, so both sides must agree on:
Initial sequence numbers
Window size
Readiness to transmit

Step 1️⃣: SYN (Synchronize)
Client → Server
Client wants to open connection
Sends SYN packet with its initial sequence number (ISN)
Example:
Client: SYN, Seq=100
“Hey server, I want to talk. My sequence number is 100.”

Step 2️⃣: SYN-ACK (Synchronize + Acknowledge)
Server → Client
Server acknowledges client’s SYN and sends its own SYN
Example:
Server: SYN, Seq=500, ACK=101
“Got your SYN. My sequence number is 500. I acknowledge your 100 + 1 = 101.”

Step 3️⃣: ACK (Acknowledge)
Client → Server
Client acknowledges server’s SYN
Example:
Client: ACK, Seq=101, ACK=501
“Got your SYN 500. ACK sent 501. Ready to communicate!”

✅ Connection Established
Now both client and server can send/receive data reliably
Sequence numbers ensure order & reliability

⚡ Quick Notes
Each side picks initial sequence numbers
ACK = Sequence number received + 1
This ensures no packets lost during connection setup

🔑 Visualization (Simple)
Client                        Server
 |  SYN (Seq=100)            |
 |-------------------------->|
 |                           | SYN-ACK (Seq=500, ACK=101)
 |<--------------------------|
 | ACK (Seq=101, ACK=501)    |
 |-------------------------->|
Connection Established ✅


Steps:
SYN → Client requests connection
SYN-ACK → Server responds
ACK → Client confirms
✅ Connection established

5️⃣ ⚡ TCP vs UDP
Feature
TCP
UDP
Type
Connection-oriented
Connectionless
Reliability
✅ Yes
❌ No
Order
Maintained
Not guaranteed
Speed
Slower
Faster


🔹 Protocols:
Transmission Control Protocol → reliable
User Datagram Protocol → fast

6️⃣ 🌐 HTTP over TCP
Flow:
 After TCP connection established
HTTP request sent by Browser eg:
 GET /index.html HTTP/1.1
Host: www.example.com

Server responds-->process  the requests and serve static and dynamic Browser recieves Http response and if request success gives Status code Ok 200

🔹 Non-Persistent HTTP
New TCP connection per request
Slow

🔹 Persistent HTTP
Same connection reused
Faster
Default in modern systems

7️⃣ 🔌 Sockets
✅ Definition
A socket is:
Endpoint for communication (IP + Port)
IP address → identifies the machine
Port number → identifies the application/service

Flow:
Client creates socket
Connects to server socket
TCP handshake happens
HTTP data flows
Socket closed / reused

8️⃣ 🧵 Server Threading Model

🔹 Single Thread
One request at a time
❌ Slow, blocking

🔹 Multi Thread
One thread per request
❌ Problems:
Too many threads
High memory usage
Context switching overhead


🔹 Thread Pool (Best Practice)
✅ Concept:
Fixed number of threads
Requests stored in queue
Threads reused

Advantages:
Better performance
Controlled memory
Reduced context switching

9️⃣ 🔄 Context Switching
✅ Definition:
CPU switching between threads
❌ Too many threads → CPU waste
✔ Thread pool reduces it

🔟 ⚙️ JavaScript & Event Loop

🔹 JavaScript Nature
Single-threaded
One call stack

❗ Problem
Blocking code freezes everything

🔁 Event Loop Solution
Components:
Call Stack
Web APIs
Callback Queue
Event Loop

Flow:
Async task → Web API
Completed → Queue
Event loop pushes to stack

⚡ Microtask vs Callback Queue
Type
Priority
Example
Microtask
High
Promise
Callback
Low
setTimeout






Code Explanation___>



Server.java
_______________________________________________
# 🧠 What This Server Does

 This is a **single-threaded TCP server** that:

1. Listens on port `8010`
2. Accepts client connections
3. Sends a message to client
4. Repeats forever

---

# 🔍 Step-by-Step Explanation

## 1️⃣ Create ServerSocket

```java
int port = 8010;
ServerSocket socket = new ServerSocket(port);
```

### ✅ Meaning:

* Server starts listening on **port 8010**
* OS binds this port to your process

👉 This is your **server endpoint (IP + Port)**
👉 Server is now ready to accept connections

---

## 2️⃣ Timeout Setup

```java
socket.setSoTimeout(20000);
```

### ✅ Meaning:

* Server will wait **20 seconds** for a connection
* If no client connects → throws exception

⚠️ Important:

* Prevents server from blocking forever

---

## 3️⃣ Infinite Loop (Server Always Running)

```java
while(true){
```

👉 Server keeps running continuously
👉 Ready to handle multiple incoming clients (one at a time)

---

## 4️⃣ Listening Message

```java
System.out.println("Server is listening on port: "+port);
```

Just for debugging/logging

---

## 5️⃣ Accept Connection 🔥 (VERY IMPORTANT)

```java
Socket acceptedConnection = socket.accept();
```

### 🚀 This is the MOST IMPORTANT LINE

👉 What happens internally:

1. Server waits (blocks here)
2. Client tries to connect
3. TCP **3-way handshake happens**
4. Connection established
5. New socket is created for that client

---

### 🧠 Important Concept

* `ServerSocket` → listens
* `Socket` → actual communication

👉 After `accept()`:

```text
Client Socket  <----TCP---->  Server Socket (acceptedConnection)
```

---

## 6️⃣ Client Info

```java
System.out.println("Connected to "+acceptedConnection.getRemoteSocketAddress());
```

### ✅ Output example:

```
Connected to /127.0.0.1:52345
```

👉 Shows client IP + port

---

## 7️⃣ Output Stream (Send Data)

```java
PrintWriter toClient = new PrintWriter(
    acceptedConnection.getOutputStream(), true
);
```

👉 Used to **send data to client**

---

## 8️⃣ Input Stream (Receive Data)

```java
BufferedReader fromClient = new BufferedReader(
    new InputStreamReader(acceptedConnection.getInputStream())
);
```

👉 Used to **receive data from client**

⚠️ Note:
You created it but **not using it yet**

---

## 9️⃣ Sending Response

```java
toClient.println("Hello World from the server");
```

👉 Server sends message to client

---

# ❗ Missing Part (Important)

You are NOT reading client input:

```java
fromClient.readLine(); // missing
```

👉 So currently:

* Client sends message ❌ ignored
* Server only responds

---

# 🔁 Full Flow (Client + Server)

```text
Client                          Server
   |                              |
   |------Connect (TCP)---------->|
   |                              |
   |------Send Message----------->|
   |                              |
   |<-----Send Response-----------|
   |                              |
Connection closes
```

---

# ⚠️ Problems in Your Server

## ❗ 1. Single Threaded

* Only one client handled at a time
* Others must wait

---

## ❗ 2. No Resource Closing

```java
acceptedConnection.close(); ❌ missing
```

👉 Leads to:

* Memory leaks
* Too many open connections

---

## ❗ 3. Not Reading Client Data

* You created `fromClient` but not using it

---

## ❗ 4. Blocking Nature

* `accept()` blocks
* Whole server waits



# 🧠 Concept Mapping

| Code         | Concept               |
| ------------ | --------------------- |
| ServerSocket | Listening socket      |
| accept()     | TCP handshake         |
| Socket       | Communication channel |
| InputStream  | Receiving data        |
| OutputStream | Sending data          |

---

# 🎯 Interview Answer

> This Java program implements a single-threaded TCP server using ServerSocket. It listens on a specific port, accepts incoming client connections via the accept() method, which internally performs a TCP handshake, and then communicates with the client using input and output streams. Each accepted connection creates a new socket used for data exchange.

---



Client.java
_______________________________________________
# 🧠 What This Code Does

👉 This is a **TCP client** that:

1. Connects to a server running on `localhost:8090`
2. Sends a message
3. Waits for a response
4. Closes connection

---

# 🔍 Step-by-Step Explanation

## 1️⃣ Port and Address

```java
int port = 8090;
InetAddress address = InetAddress.getByName("localhost");
```

### ✅ Meaning:

* `localhost` → your own machine (IP = `127.0.0.1`)
* Port `8090` → where server is listening

👉 This is your **destination (IP + Port)**
👉 This forms the **server socket endpoint**

---

## 2️⃣ Socket Creation

```java
Socket socket = new Socket(address, port);
```

### 🔥 Important:

👉 This line does A LOT internally:

* Creates a **client socket**
* Initiates **TCP connection**
* Performs **3-way handshake automatically**

### Behind the scenes:

```
Client → SYN
Server → SYN-ACK
Client → ACK
```

✅ Now connection is established

---

## 3️⃣ Output Stream (Send Data)

```java
PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
```

### ✅ Meaning:

* `getOutputStream()` → used to **send data to server**
* `PrintWriter` → makes it easy to send text

---

## 4️⃣ Input Stream (Receive Data)

```java
BufferedReader fromSocket = new BufferedReader(
    new InputStreamReader(socket.getInputStream())
);
```

### ✅ Meaning:

* `getInputStream()` → used to **receive data from server**
* `BufferedReader` → reads text line by line

---

## 5️⃣ Sending Data

```java
toSocket.println("Hello World from socket " + socket.getLocalSocketAddress());
```

### ✅ What happens:

* Message sent through **TCP socket**
* Goes to server

👉 `getLocalSocketAddress()` gives:

```
client_ip:random_port
```

Example:

```
127.0.0.1:52345
```

---

## 6️⃣ Receiving Data

```java
String line = fromSocket.readLine();
```

### ✅ What happens:

* Client **waits (blocks)** until server sends response
* Reads one line

⚠️ Important:

* If server doesn’t respond → this line **blocks forever**

---

## 7️⃣ Closing Resources

```java
toSocket.close();
fromSocket.close();
socket.close();
```

### ✅ Why important:

* Frees memory
* Closes TCP connection
* Releases port

---

# 🔁 Full Flow (Concept Mapping)

```
Client Code Starts
      ↓
Create Socket
      ↓
TCP 3-Way Handshake
      ↓
Connection Established
      ↓
Send Message (OutputStream)
      ↓
Server Receives
      ↓
Server Sends Response
      ↓
Client Reads (InputStream)
      ↓
Close Connection
```

---

# ⚠️ Important Observations

## ❗ 1. Blocking Nature

```java
fromSocket.readLine();
```

👉 This is **blocking I/O**

* Thread waits until response comes

---

## ❗ 2. Single Request Only

* This client sends **only one request**
* Not reusable

---

## ❗ 3. No Error Handling for Server Down

If server not running:
👉 `Connection refused` error

---

# 💡 Real World Mapping

| Your Code    | Real Concept            |
| ------------ | ----------------------- |
| Socket       | TCP connection          |
| OutputStream | Sending HTTP request    |
| InputStream  | Receiving HTTP response |
| readLine()   | Waiting for server      |

---

# 🎯 Interview Explanation (Very Important)

> This Java program creates a TCP client socket that connects to a server using an IP address and port. It establishes a connection via TCP handshake, sends data using an output stream, receives a response using an input stream, and then closes the connection. The communication is blocking, meaning the client waits until the server responds.

