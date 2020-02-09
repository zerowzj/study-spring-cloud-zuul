package study.springcloud.zuul.support.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GlobalFallbackProvider implements FallbackProvider {

    /**
     * 返回值表示需要针对此微服务做回退处理
     * 该名称一定要是注册进入 eureka 微服务中的那个 serviceId 名称
     */
    @Override
    public String getRoute() {
        //服务id，如果需要所有调用都支持回退，则return "*"或return null
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.info("route={}", route);
        log.error("", cause);
        return new CustomClientHttpResponse(getRoute());
    }
}
