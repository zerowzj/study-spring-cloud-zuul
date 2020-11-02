package study.springcloud.zuul.support.zuul;

import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.context.annotation.Bean;

public class ZuulCfg {

    /**
     * 重写Location头信息
     */
    @Bean
    public LocationRewriteFilter locationRewriteFilter() {
        return new LocationRewriteFilter();
    }
}
