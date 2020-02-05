package study.springcloud.zuul.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableHystrixDashboard
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "study.springcloud.zuul")
public class SpringBootCfg {

}