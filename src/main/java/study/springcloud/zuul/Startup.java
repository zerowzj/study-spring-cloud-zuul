package study.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import study.springcloud.zuul.support.config.SpringBootCfg;

public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}