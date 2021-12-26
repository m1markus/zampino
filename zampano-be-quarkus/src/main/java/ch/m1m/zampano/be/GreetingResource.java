package ch.m1m.zampano.be;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingResource.class);

    private Counter counterHelloCalls = null;

    //@Inject
    GreetingGenerator greetingGenerator;

    GreetingResource(MeterRegistry registry, GreetingGenerator gg) {
        counterHelloCalls = registry.counter("requests.hello");
        this.greetingGenerator = gg;
    }

    /*
    @Inject
    void setCDIGreetingGenerator(GreetingGenerator gg) {
        this.greetingGenerator = gg;
    }
    */

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        //org.jboss.logging.Logger jbossLogger = org.jboss.logging.Logger.getLogger("my");

        //counterHelloCalls.increment();

        // org.jboss.logging.Logger LOG = org.jboss.logging.Logger.getLogger(GreetingResource.class);
        String message = String.format("%s from REST endpoint", greetingGenerator.getGreeting(null));

        LOG.info(message);

        return message;
    }
}
