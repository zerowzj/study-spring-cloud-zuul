package study.springcloud.zuul.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
//@ServletComponentScan(basePackages = "study.springcloud.zuul")
@SpringBootApplication(scanBasePackages = "study.springcloud.zuul")
public class SpringBootCfg {

}