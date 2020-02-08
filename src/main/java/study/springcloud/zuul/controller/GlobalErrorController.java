package study.springcloud.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class GlobalErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        String uri = request.getRequestURI();
        log.info("uri={}", uri);
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        log.info("{}", statusCode);
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String message = (String) request.getAttribute("javax.servlet.error.message");
        return "faaaaaaaaa";
    }
}
