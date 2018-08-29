package pers.yipeng.ssmtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName NginxTestController
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/19 15:21
 * @Version 1.0
 **/
@Controller
public class NginxTestController {


    @RequestMapping("/nginxtest")
    public String domainTest(Model model){
        String str="ssm-web不是默认工程,通过www.nginxtest1.com访问Nginx";
        model.addAttribute("message",str);
        return "nginxTest";
    }
}
