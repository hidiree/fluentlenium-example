package util;

import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;
import org.junit.rules.ExternalResource;

import java.io.File;

public class GlassFishTamer extends ExternalResource {

    private final String contextRoot;
    private final int port;
    private GlassFish glassFish;

    public GlassFishTamer(String contextRoot, int port) {
        this.contextRoot = contextRoot;
        this.port = port;
    }

    @Override
    protected void before() throws Throwable {
        GlassFishProperties prop = new GlassFishProperties();
        prop.setPort("http-listener", port);

        glassFish = GlassFishRuntime.bootstrap().newGlassFish(prop);
        glassFish.start();

        ScatteredArchive war = new ScatteredArchive(contextRoot, ScatteredArchive.Type.WAR, new File("src/main/webapp"));
        // TODO
        war.addClassPath(new File("build", "classes"));

        glassFish.getDeployer().deploy(war.toURI(), "--contextroot", contextRoot);
    }

    @Override
    protected void after() {
        try {
            glassFish.stop();
            glassFish.dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
