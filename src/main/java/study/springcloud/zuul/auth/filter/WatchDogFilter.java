package study.springcloud.zuul.auth.filter;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class WatchDogFilter extends OncePerRequestFilter {

    private static final String KEY_URI = "uri";

    private static final String KEY_REQUEST_ID = "request_id";

    private static final String HEADER_KEY_REQUEST_ID = "Request-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String uri = request.getRequestURI();
        MDC.put(KEY_URI, uri);
        MDC.put(KEY_REQUEST_ID, uri);
        try {
            doFilter(request, response, filterChain);
        } finally {
            log.info("[{}] cost time {} ms", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            MDC.remove(KEY_URI);
            MDC.remove(KEY_REQUEST_ID);
        }
    }

    private String abainRequestId(HttpServletRequest request) {
        return null;
    }
}
