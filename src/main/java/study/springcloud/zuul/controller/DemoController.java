package study.springcloud.zuul.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        if (1 == 1) {
            throw new RuntimeException("demo exception");
        }
        return "this is demo";
    }
}
