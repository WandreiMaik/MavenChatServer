package verteilteSysteme;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Created by z003aknc on 10.03.2016.
 */
public class RestServer
{
    public static void main(String[] args) throws Exception {
        Component component = new Component();

        component.getServers().add(Protocol.HTTP,8081);

        component.getDefaultHost().attach("/rest", new HelloWorldApp());

        component.start();
    }
}
