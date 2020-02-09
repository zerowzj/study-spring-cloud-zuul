package study.springcloud.zuul.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "this is demo";
    }
}
