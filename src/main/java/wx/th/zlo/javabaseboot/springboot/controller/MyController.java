package wx.th.zlo.javabaseboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/aa")
    @ResponseBody
    public String a() {
        System.out.println("123");
        return "123";
    }
}
