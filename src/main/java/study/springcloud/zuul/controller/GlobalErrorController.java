package study.springcloud.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class GlobalErrorController implements ErrorController {

    private static final String KEY_STATUS_CODE = "javax.servlet.error.status_code";

    private static final String KEY_EXCEPTION = "javax.servlet.error.exception";

    private static final String KEY_MESSAGE = "javax.servlet.error.message";

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        String uri = request.getRequestURI();
        log.info("uri={}", uri);
        Integer statusCode = (Integer) request.getAttribute(KEY_STATUS_CODE);
        log.info("{}", statusCode);
        Exception ex = (Exception) request.getAttribute(KEY_EXCEPTION);
        String msg = (String) request.getAttribute(KEY_MESSAGE);
        return "faaaaaaaaa";
    }
}
