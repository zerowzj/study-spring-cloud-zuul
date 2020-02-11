package study.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 在请求被路由之前调用
 */
@Slf4j
@Component
public class PreZFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("======> pre filter");
//        if (1 == 1) {
//            throw new RuntimeException("PreZFilter");
//        }
        return null;
    }
}
