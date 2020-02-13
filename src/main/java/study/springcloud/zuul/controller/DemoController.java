package study.springcloud.zuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/sayHi")
    public String sayHi() {
        if (1 == 1) {
            throw new RuntimeException("controller exception");
        }
        return "this is demo";
    }

    @RequestMapping("/throwException")
    public String throwException() {
        if (1 == 1) {
            throw new RuntimeException("controller exception");
        }
        return "this is demo";
    }
}
