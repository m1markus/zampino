package ch.m1m.zampano.be;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingResource.class);

    private final Counter counterHelloCalls;


    GreetingResource(MeterRegistry registry) {
        counterHelloCalls = registry.counter("requests.hello");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        counterHelloCalls.increment();

        // org.jboss.logging.Logger LOG = org.jboss.logging.Logger.getLogger(GreetingResource.class);

        LOG.info("Hello World from REST endpoint");

        return "hello response";
    }
}
