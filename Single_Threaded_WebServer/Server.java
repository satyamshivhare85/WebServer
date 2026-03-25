import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    
    public void run() throws IOException, UnknownHostException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port); //socket===> Ip+Port
        socket.setSoTimeout(20000);
        while(true){
            System.out.println("Server is listening on port: "+port);
            Socket acceptedConnection = socket.accept();  //accept connection -->from client
            System.out.println("Connected to "+acceptedConnection.getRemoteSocketAddress());//client Infor s client IP + port
            // After accept()Client Socket  <----TCP---->  Server Socket (acceptedConnection)
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true); //Data==>client
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));//Recieive data from client
            toClient.println("Hello World from the server");
        }
    }

    public static void main(String[] args){
        Server server = new Server();
        try{
            server.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}