package study.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 在routing和error过滤器之后被调用
 */
@Slf4j
@Component
public class PostZFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

   @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("======> post filter");
        RequestContext ctx = RequestContext.getCurrentContext();

        String uri = (String) ctx.get(FilterConstants.REQUEST_URI_KEY);
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        int statusCode = ctx.getResponseStatusCode();
        log.info("serviceId={}, uri={}, status_code={}", serviceId, uri, statusCode);

        return null;
    }
}
