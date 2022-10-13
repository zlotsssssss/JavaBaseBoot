package wx.th.zlo.javabaseboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MyController {

    @RequestMapping("/post")
    @ResponseBody
    public String test(String name, String age, @RequestBody Map<String,Object> map){
        return "123";
    }

    @RequestMapping("/aa")
    @ResponseBody
    public String a() {
        System.out.println("123");
        return "123";
    }
}
