package study.springcloud.zuul.filter;//package study.springcloud.zuul.filter;
//
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class RouteZFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        log.info("{}", uri);
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() {
        log.info("route...................");
        RequestContext ctx = RequestContext.getCurrentContext();
//        ctx.setSendZuulResponse(false);
//        ctx.setResponseBody("sadfasdf");
//        ctx.getResponse().setContentType("application/json; charset=utf-8");
        return null;
    }
}
