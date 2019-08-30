import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            do {
                Socket socket = serverSocket.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                System.out.println("Someone just connected !");
                output.println("Send a message and I will send it back in capital letters !");
                output.flush();
                String message = input.readLine();
                output.println(message.toUpperCase());
                output.flush();
            }while(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
