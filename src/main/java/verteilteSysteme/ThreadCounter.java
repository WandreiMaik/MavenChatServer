package verteilteSysteme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by z003aknc on 10.03.2016.
 */
public class ThreadCounter
{
    private static int count = 0;

    private static Object mutex = new Object();

    private static void increment()
    {
        synchronized (mutex)
        {
            count = count + 1;
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100000; i++)
        {
            executor.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    increment();
                }
            });
        }

        executor.shutdown();

        try
        {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException e)
        {

        }

        System.out.println(count);
    }
}
