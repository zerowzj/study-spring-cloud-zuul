package study.springcloud.zuul.controller;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcloud.zuul.support.utils.Results;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//        if(1==1){
//            throw new RuntimeException("111111111111111");
//        }
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable cause = ctx.getThrowable();
        String uri = request.getRequestURI();
        log.info("uri={}", uri);
        Integer code = (Integer) request.getAttribute(KEY_STATUS_CODE);
        Exception ex = (Exception) request.getAttribute(KEY_EXCEPTION);
        String msg = (String) request.getAttribute(KEY_MESSAGE);

        Map<String, Object> body = Results.error("9999", "系统异常");
        MultiValueMap<String, String> headers = null;
        ResponseEntity<Map<String, Object>> entity = new ResponseEntity(body, headers, HttpStatus.OK);
        return entity;
    }
}
