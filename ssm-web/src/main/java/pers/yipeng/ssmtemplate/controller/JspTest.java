package pers.yipeng.ssmtemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pers.yipeng.ssmtemplate.pojo.UserTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JspTest
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/11 16:25
 * @Version 1.0
 **/
@Controller
public class JspTest {
    @RequestMapping(value = "/eltest")
    public ModelAndView ELTest(ModelAndView mv){
        //尼古拉斯·赵四
        UserTest userTest0 = new UserTest();
        userTest0.setUsername("黑暗魔君·索伦");
        userTest0.setSex("不详");
        userTest0.setAddress("魔多");
        //尼古拉斯·赵四
        UserTest userTest1 = new UserTest();
        userTest1.setUsername("尼古拉斯·赵四");
        userTest1.setSex("男");
        userTest1.setAddress("纳尼亚");
        //莱昂纳多·小沈阳
        UserTest userTest2 = new UserTest();
        userTest2.setUsername("莱昂纳多·小沈阳");
        userTest2.setSex("男");
        userTest2.setAddress("铁岭");
        //约翰尼·宋小宝
        UserTest userTest3 = new UserTest();
        userTest3.setUsername("约翰尼·宋小宝");
        userTest3.setSex("男");
        userTest3.setAddress("光明村");
        //克里斯蒂安·刘能
        UserTest userTest4 = new UserTest();
        userTest4.setUsername("克里斯蒂安·刘能");
        userTest4.setSex("男");
        userTest4.setAddress("哈尔滨");

        //1）遍历List<String>的值
        ArrayList<String> strList = new ArrayList<>();
        strList.add("姓名：张三");
        strList.add("年龄：20岁");

        mv.addObject("strList",strList);
        // 2）遍历List<User>的值
        ArrayList<UserTest> userList = new ArrayList<>();
        userList.add(userTest1);
        userList.add(userTest2);
        userList.add(userTest3);
        userList.add(userTest4);

        mv.addObject("userList",userList);
        // 3）遍历Map<String,String>的值
        HashMap<String, String> strtwoMap = new HashMap<>();
        strtwoMap.put("姓名","韩梅梅");
        strtwoMap.put("年龄","20岁");
        strtwoMap.put("性别","女");
        mv.addObject("strtwoMap",strtwoMap);
        //4）遍历Map<String,User>的值
        HashMap<String, UserTest> struserMap = new HashMap<>();
        struserMap.put("赵四",userTest1);
        struserMap.put("沈阳",userTest2);
        struserMap.put("小宝",userTest3);
        struserMap.put("刘能",userTest4);
        mv.addObject("struserMap",struserMap);
        // 5）遍历Map<User,Map<String,User>>的值,entry.key-----User,entry.value------List<String,User>
        HashMap<UserTest, Map<String, UserTest>> usermapMap = new HashMap<>();
        usermapMap.put(userTest0,struserMap);
        mv.addObject("usermapMap",usermapMap);

        mv.setViewName("jspTest");
        return mv;
    }
}
