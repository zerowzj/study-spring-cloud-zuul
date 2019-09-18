package study.springcloud.zuul.support.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@ServletComponentScan(basePackages = "study.springcloud.zuul")
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "study.springcloud.zuul")
public class SpringBootCfg {

}