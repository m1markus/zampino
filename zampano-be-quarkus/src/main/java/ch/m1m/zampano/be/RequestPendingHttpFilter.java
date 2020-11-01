package ch.m1m.zampano.be;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// https://quarkus.io/blog/quarkus-and-web-ui-development-mode/

@WebFilter(urlPatterns = "/*")
public class RequestPendingHttpFilter extends HttpFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestPendingHttpFilter.class);
    private static final AtomicLong PENDING_REQUESTS = new AtomicLong(0);

    RequestPendingHttpFilter(MeterRegistry registry) {
        registry.gauge("http_num_requests_pending", this,
                RequestPendingHttpFilter::getPendingRequests);

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        long actualPendingRequest = PENDING_REQUESTS.incrementAndGet();
        LOG.info("Requests pending http filter begin num={}", actualPendingRequest);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        chain.doFilter(request, response);
        actualPendingRequest = PENDING_REQUESTS.decrementAndGet();
        LOG.info("Requests pending http filter end num={}", actualPendingRequest);
    }

    private long getPendingRequests() {
        return PENDING_REQUESTS.get();
    }
}
