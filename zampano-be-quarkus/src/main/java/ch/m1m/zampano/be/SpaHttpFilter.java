package ch.m1m.zampano.be;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.regex.Pattern;

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
public class SpaHttpFilter extends HttpFilter {

    private static final Logger LOG = LoggerFactory.getLogger(SpaHttpFilter.class);

    private static final Pattern FILE_NAME_PATTERN = Pattern.compile(".*[.][a-zA-Z\\d]+");

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        LOG.info("SPA http filter begin");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        chain.doFilter(request, response);

        if (response.getStatus() == 404) {
            String path = request.getRequestURI().substring(
                    request.getContextPath().length()).replaceAll("[/]+$", "");
            if (!FILE_NAME_PATTERN.matcher(path).matches()) {
                // We could not find the resource, i.e. it is not anything known to the server (i.e. it is not a REST
                // endpoint or a servlet), and does not look like a file so try handling it in the front-end routes
                // and reset the response status code to 200.
                response.setStatus(200);
                LOG.info("SPA http filter has forwarded the request");
                request.getRequestDispatcher("/").forward(request, response);
            }
        }
        LOG.info("SPA http filter end");
    }
}