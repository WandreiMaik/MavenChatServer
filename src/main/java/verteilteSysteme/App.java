package verteilteSysteme;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static List<Socket> clients;

    public static void main( String[] args ) throws IOException {
        ServerSocket server = new ServerSocket(4321);

        System.out.printf("Starte Anwendung.");

        clients = new ArrayList<Socket>();

        while (true)
        {
            try
            {
                clients.add(server.accept());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            new Thread(new EchoThread(clients.get(clients.size() - 1))).start();
        }
    }

    public static void broadcast(String message) throws IOException {
        for(Socket client : clients)
        {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            out.println(String.format("%s", message));
        }
    }
}
