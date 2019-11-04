package study.springcloud.zuul.support.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
//        ctx.setSendZuulResponse(false);
//        ctx.setResponseBody("sadfasdf");
//        ctx.getResponse().setContentType("application/json; charset=utf-8");
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
