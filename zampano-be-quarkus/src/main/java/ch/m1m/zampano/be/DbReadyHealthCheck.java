package ch.m1m.zampano.be;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class DbReadyHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        String checkName = "Readiness DB connection 'syrius'";
        boolean isUp = true;
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named(checkName);
        responseBuilder.state(isUp);
        responseBuilder.withData("bar", "barValue");
        //responseBuilder.up();
        //responseBuilder.down();
        return responseBuilder.build();
    }
}
