package verteilteSysteme;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by z003aknc on 03.03.2016.
 */
public class EchoThread implements Runnable
{
    protected Socket _client;

    public EchoThread(Socket client)
    {
        _client = client;
    }

    public void run()
    {
        try
        {
            Scanner in = new Scanner(_client.getInputStream());

            PrintWriter out = new PrintWriter(_client.getOutputStream(), true);

            String input = in.nextLine();

            App.broadcast(new Date(System.currentTimeMillis()).toString() + ": " + input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return;
    }
}
