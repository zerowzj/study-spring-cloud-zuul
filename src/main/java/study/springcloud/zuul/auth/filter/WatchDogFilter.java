package study.springcloud.zuul.auth.filter;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import study.springcloud.zuul.support.utils.MDCs;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class WatchDogFilter extends OncePerRequestFilter {

    private static final String HEADER_KEY_REQUEST_ID = "Request-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("i am watch dog");
        Stopwatch stopwatch = Stopwatch.createStarted();
        String uri = request.getRequestURI();
        String requestId = obtainRequestId(request);
        MDCs.put(uri, requestId);
        try {
            doFilter(request, response, filterChain);
        } finally {
            log.info("[{}] cost time {} ms", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            MDCs.remove();
        }
    }

    private String obtainRequestId(HttpServletRequest request) {
        return request.getHeader(HEADER_KEY_REQUEST_ID);
    }
}
