package verteilteSysteme;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * Created by z003aknc on 10.03.2016.
 */
public class HelloWorldApp extends Application
{

    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/hello", HelloWorldResource.class);
        return router;
    }
}
