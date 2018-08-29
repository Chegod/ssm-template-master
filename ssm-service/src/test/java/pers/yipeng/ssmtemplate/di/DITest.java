package pers.yipeng.ssmtemplate.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.yipeng.ssmtemplate.pojo.UserTest;

/**
 * @ClassName DITest
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/27 21:55
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext_test.xml"})
public class DITest {
    @Autowired
    UserTest userTest;

    //测试setter注入,必须是public void setUsername(String username)
    @Test
    public void test1(){
        System.out.println(userTest.getUsername());
    }
}
