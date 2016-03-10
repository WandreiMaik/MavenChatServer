package verteilteSysteme;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by z003aknc on 10.03.2016.
 */
public class HelloWorldResource extends ServerResource
{
    @Get
    public String helloWorld()
    {
        return new World("Hello World").message;
    }
}
