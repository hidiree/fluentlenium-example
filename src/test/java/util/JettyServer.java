package util;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by hijiri on 2014/01/04.
 */
public class JettyServer {

    public static void main(String[] args) throws Exception {
        WebAppContext context = new WebAppContext();
        context.setContextPath("/devkan-calc");
        context.setWar("src/main/webapp");

        ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "services");
        context.addServlet(servletHolder, "/services/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
