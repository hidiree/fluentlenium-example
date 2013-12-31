package services;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorIT extends JerseyTest {

    @Test
    public void testAdd() {
        String actual = target("/calc/add")
                .queryParam("a", "1")
                .queryParam("b", "1")
                .request()
                .get(String.class);

        assertThat(actual, is("2"));
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(Calculator.class);
    }
}
