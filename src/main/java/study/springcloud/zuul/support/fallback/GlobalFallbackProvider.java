package study.springcloud.zuul.support.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class GlobalFallbackProvider implements FallbackProvider {

    /**
     * 返回值表示需要针对此微服务做回退处理
     */
    @Override
    public String getRoute() {
        //serviceId，如果需要所有调用都支持回退，则return "*"或return null
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.info("route={}", route);
        log.error("", cause);
        return new CustomClientHttpResponse(getRoute());
    }
}
