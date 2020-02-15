package study.springcloud.zuul.auth.filter;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
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
@Order(1)
@Component
public class WatchDogFilter extends OncePerRequestFilter {

    private static final String HEADER_KEY_REQUEST_ID = "Request-Id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String uri = request.getRequestURI();
        String requestId = request.getHeader(HEADER_KEY_REQUEST_ID);
        MDCs.put(uri, requestId);

        log.info("i am watch dog");
        try {
            filterChain.doFilter(request, response);
        } finally {
            log.info("[{}] cost time [{} ms]", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            MDCs.remove();
        }
    }
}
