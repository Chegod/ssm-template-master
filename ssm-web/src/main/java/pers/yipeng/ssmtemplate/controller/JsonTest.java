package pers.yipeng.ssmtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pers.yipeng.ssmtemplate.pojo.Items;

/**
 * @ClassName JsonTest
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/30 22:30
 * @Version 1.0
 **/
@Controller
public class JsonTest {

    @RequestMapping(value = "/jsonpost",method = RequestMethod.POST)
    @ResponseBody
    public Items receivePost(Items items){

        return items;
    }

    @RequestMapping(value = "/jsonajax",method = RequestMethod.POST)
    @ResponseBody
    public Items receiveJson(@RequestBody Items items){

        return items;
    }

    @RequestMapping(value = "/jsontestpage")
    public String showJsonPage(){

        return "jsonTest";
    }
}
