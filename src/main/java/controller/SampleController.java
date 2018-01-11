package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.HttpUtil;

@Controller
@EnableAutoConfiguration
public class SampleController {
    
    private static String url = "http://localhost:8080/hms-web/evaluate/sendRequest.action";

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/testrequest")
    @ResponseBody
    String testRequest() throws Exception { 
        return HttpUtil.httpPostWithJSON(url);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
