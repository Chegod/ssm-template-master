package pers.yipeng.ssmtemplate.aopAnnotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.yipeng.ssmtemplate.aop.TargetObject;

/**
 * @ClassName MonitorTimerTest
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/6 16:15
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-AopAnnotation.xml")
public class AopAnnotationTest {
    @Autowired
    TargetObject target;

    @Test
    public void test1(){
        target.sleep2000ms();
    }
}
