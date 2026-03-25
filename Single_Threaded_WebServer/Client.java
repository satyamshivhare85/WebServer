// Client Code Starts
//       ↓
// Create Socket
//       ↓
// TCP 3-Way Handshake
//       ↓
// Connection Established
//       ↓
// Send Message (OutputStream)
//       ↓
// Server Receives
//       ↓
// Server Sends Response
//       ↓
// Client Reads (InputStream)
//       ↓
// Close Connection

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    public void run() throws UnknownHostException, IOException{
//         localhost → your own machine (IP = 127.0.0.1)
//         Port 8090 → where server is listening

//         This is your destination (IP + Port)
//          This forms the server socket endpoint
        int port = 8090;
        InetAddress address = InetAddress.getByName("localhost");   //Ip adress
        Socket socket = new Socket(address, port);  //Socket-->made by Ip adress+Port
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);//used to send data to server
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));//used to receive data from server  BufferedReader → reads text line by line
        toSocket.println("Hello World from socket "+socket.getLocalSocketAddress());
        String line = fromSocket.readLine();    //Read one line client waits blocks until server Responds
        toSocket.close();//free memory
        fromSocket.close();//closes tcp
        socket.close();//release port
    }
    
    public static void main(String[] args) {
        Client singleThreadedWebServer_Client = new Client();
        try{
            singleThreadedWebServer_Client.run();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}