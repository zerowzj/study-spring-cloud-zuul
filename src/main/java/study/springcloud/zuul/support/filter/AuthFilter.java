package study.springcloud.zuul.support.filter;

import com.netflix.zuul.ZuulFilter;

public class AuthFilter extends ZuulFilter {



    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
