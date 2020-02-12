package study.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
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
        RequestContext ctx = RequestContext.getCurrentContext();
       String uri = (String) ctx.get(FilterConstants.REQUEST_URI_KEY);
       log.info("uri={}", uri);
//        if (1 == 1) {
//            throw new RuntimeException("PreZFilter");
//        }
        return null;
    }
}
