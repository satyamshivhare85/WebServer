Full Basic Notes Fundamentals:

In client-server architecture, the client sends a request which is resolved via DNS into an IP address. A TCP connection is established using a 3-way handshake, and HTTP requests are sent over this connection using sockets. The server processes the request (static or dynamic) and sends a response back. To handle multiple requests efficiently, servers use thread pools or asynchronous models, while JavaScript uses an event loop to handle concurrency despite being single-threaded.
1️⃣ 🧠 Server (Core Concept) ✅ Definition A server is a software (or hardware) system that: Receives requests from clients(Static or Dynamic) and provides resources, data, or services over a network.

📦 Types of Content 🔹 Static Content Pre-built files Same for all users Examples: HTML, CSS, JS, Images

🔹 Dynamic Content Generated at runtime Depends on: User input Business logic Database Examples: Login system Dashboard Recommendations

2️⃣ 🌐 Web Server vs Application Server 🔹 Web Server Handles HTTP requests Serves static content Fast, no heavy logic Examples: Apache HTTP Server Nginx

🔹 Application Server Runs business logic Communicates with DB Generates dynamic response Examples: Node.js Django

🎯 One-Line Difference Web server serves static content, while application server handles logic and dynamic content.

3️⃣ 🔁 Client–Server Architecture Flow ✅ Step-by-Step Flow User enters URL DNS resolves domain → IP Domain Name System Client connects using Transmission Control Protocol TCP 3-way handshake happens HTTP request sent Hypertext Transfer Protocol Server processes request Response sent (HTML/JSON) Browser renders UI

4️⃣ 🔐 TCP 3-Way Handshake

Purpose: To establish a reliable connection between client and server before sending data. TCP is connection-oriented, so both sides must agree on: Initial sequence numbers Window size Readiness to transmit

Step 1️⃣: SYN (Synchronize) Client → Server Client wants to open connection Sends SYN packet with its initial sequence number (ISN) Example: Client: SYN, Seq=100 “Hey server, I want to talk. My sequence number is 100.”

Step 2️⃣: SYN-ACK (Synchronize + Acknowledge) Server → Client Server acknowledges client’s SYN and sends its own SYN Example: Server: SYN, Seq=500, ACK=101 “Got your SYN. My sequence number is 500. I acknowledge your 100 + 1 = 101.”

Step 3️⃣: ACK (Acknowledge) Client → Server Client acknowledges server’s SYN Example: Client: ACK, Seq=101, ACK=501 “Got your SYN 500. ACK sent 501. Ready to communicate!”

✅ Connection Established Now both client and server can send/receive data reliably Sequence numbers ensure order & reliability

⚡ Quick Notes Each side picks initial sequence numbers ACK = Sequence number received + 1 This ensures no packets lost during connection setup

🔑 Visualization (Simple) Client Server | SYN (Seq=100) | |-------------------------->| | | SYN-ACK (Seq=500, ACK=101) |<--------------------------| | ACK (Seq=101, ACK=501) | |-------------------------->| Connection Established ✅

Steps: SYN → Client requests connection SYN-ACK → Server responds ACK → Client confirms ✅ Connection established

5️⃣ ⚡ TCP vs UDP Feature TCP UDP Type Connection-oriented Connectionless Reliability ✅ Yes ❌ No Order Maintained Not guaranteed Speed Slower Faster

🔹 Protocols: Transmission Control Protocol → reliable User Datagram Protocol → fast

6️⃣ 🌐 HTTP over TCP Flow: After TCP connection established HTTP request sent by Browser eg: GET /index.html HTTP/1.1 Host: www.example.com

Server responds-->process the requests and serve static and dynamic Browser recieves Http response and if request success gives Status code Ok 200

🔹 Non-Persistent HTTP New TCP connection per request Slow

🔹 Persistent HTTP Same connection reused Faster Default in modern systems

7️⃣ 🔌 Sockets ✅ Definition A socket is: Endpoint for communication (IP + Port) IP address → identifies the machine Port number → identifies the application/service

Flow: Client creates socket Connects to server socket TCP handshake happens HTTP data flows Socket closed / reused

8️⃣ 🧵 Server Threading Model

🔹 Single Thread One request at a time ❌ Slow, blocking

🔹 Multi Thread One thread per request ❌ Problems: Too many threads High memory usage Context switching overhead

🔹 Thread Pool (Best Practice) ✅ Concept: Fixed number of threads Requests stored in queue Threads reused

Advantages: Better performance Controlled memory Reduced context switching

9️⃣ 🔄 Context Switching ✅ Definition: CPU switching between threads ❌ Too many threads → CPU waste ✔ Thread pool reduces it

🔟 ⚙️ JavaScript & Event Loop

🔹 JavaScript Nature Single-threaded One call stack

❗ Problem Blocking code freezes everything

🔁 Event Loop Solution Components: Call Stack Web APIs Callback Queue Event Loop

Flow: Async task → Web API Completed → Queue Event loop pushes to stack

⚡ Microtask vs Callback Queue Type Priority Example Microtask High Promise Callback Low setTimeout

🚀 Built a High-Performance Web Server from Scratch in Java!

Over the past few days, I deep-dived into core backend fundamentals by building:

🔹 Single-Threaded Server
🔹 Multi-Threaded Server
🔹 Thread Pool-based Server (using ExecutorService)

💡 What I learned:

* How client-server communication works over sockets
* TCP/IP fundamentals including the 3-way handshake
* How requests travel between client and server
* Handling concurrent requests using threads
* Why thread pools are more efficient than creating threads manually
* Real-world scalability challenges

📊 Performance Testing using Apache JMeter:

* Simulated thousands of concurrent users
* Achieved ~60,000 requests/minute ⚡
* Scaled up to ~1000 requests/second
* Analyzed:
  ✔ Throughput
  ✔ Latency
  ✔ Deviation (stability)
  ✔ Response times

📈 Key Insight:
Single-threaded servers fail under load ❌
Multi-threading improves performance ✔
Thread pools provide optimal scalability & stability 🚀

🔧 Tech Stack:
Java | Sockets | Multithreading | ExecutorService | Apache JMeter

📂 For deeper insights, implementation details, and performance graphs:
👉 Check out the GitHub repository (README.md included)

This project helped me truly understand how real backend systems handle traffic at scale.

Would love feedback and suggestions from the community 🙌

#Java #BackendDevelopment #SystemDesign #Multithreading #JMeter #LearningInPublic #SoftwareEngineering
