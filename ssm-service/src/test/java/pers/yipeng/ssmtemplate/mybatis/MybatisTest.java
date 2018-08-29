package pers.yipeng.ssmtemplate.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.yipeng.ssmtemplate.mapper.OrderMapper;
import pers.yipeng.ssmtemplate.mapper.UserMapper;
import pers.yipeng.ssmtemplate.mapper.UserMapperTest;
import pers.yipeng.ssmtemplate.pojo.*;
import pers.yipeng.ssmtemplate.pojo.UserExample.Criteria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/7 17:43
 * @Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext_dao.xml", "classpath:spring/applicationContext_trans.xml"})
public class MybatisTest {

    @Autowired
    private UserMapperTest userMapperTest;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test1() throws ParseException {
        String[] configs = {"spring/applicationContext_dao.xml", "spring/applicationContext_trans.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configs);
        UserMapperTest userMapperTest = context.getBean(UserMapperTest.class);

        UserTest userTest = new UserTest();
        userTest.setUsername("赵日天");
        userTest.setSex("男");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("1999-2-22");
        userTest.setBirthday(parse);
        userTest.setAddress("纳尼亚");

        userMapperTest.insertUser(userTest);
        System.out.println("插入后表中的id" + userTest.getId());
    }

    @Test
    //测试UUID
    public void test2() throws ParseException {
        UserTest userTest = new UserTest();
        userTest.setUsername("赵日天");
        userTest.setSex("男");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("1999-2-22");
        userTest.setBirthday(parse);
        userTest.setAddress("纳尼亚");

        userMapperTest.insertUserIncrUUID(userTest);
        System.out.println("插入后表中的id==" + userTest.getId());
    }

    @Test
    //模糊查询
    public void test3() throws ParseException {

        List<UserTest> userTestList = userMapperTest.fuzzyQueryUser("张");
        Iterator<UserTest> iterator = userTestList.iterator();
        while (iterator.hasNext()) {
            UserTest userTest = iterator.next();
            System.out.println(userTest.getUsername());
        }
    }

    @Test
    //根据用户名模糊查询用户信息，查询条件放到QueryVo的user属性中。
    public void test4() throws ParseException {
        QueryVo queryVo = new QueryVo();
        UserTest userTest = new UserTest();
        userTest.setUsername("张");
        queryVo.setUserTest(userTest);

        List<UserTest> userTestList = userMapperTest.selectUserByQueryVo(queryVo);
        Iterator<UserTest> iterator = userTestList.iterator();
        while (iterator.hasNext()) {
            UserTest userTest1 = iterator.next();
            System.out.println(userTest1.getUsername());
        }
    }

    /*查询所有订单信息
    Order中用户id的名称为userId，数据库中的用户id名称为user_id,需要resultMap映射
    */
    @Test
    public void test5() {
        List<Order> orderList = orderMapper.queryOrderAll();
        for(Order order:orderList)
        System.out.println("订单id："+order.getId()+"\n用户id："+order.getUserId()+"\n下单时间："+order.getCreatetime());
    }

    //查询所有订单信息，关联查询下单用户信息。
    @Test
    public void test6(){
        List<OrderUser> orderUserList = orderMapper.queryOrderUser();
        for(OrderUser orderUser:orderUserList){
            System.out.println("订单id："+orderUser.getId()+"，订单number："+orderUser.getNumber()+"\n用户id："+orderUser.getUserId()+"，用户名称："+orderUser.getUsername()+"，用户地址："+orderUser.getAddress());
        }
    }
    //查询记录数
    @Test
    public void test7(){
        UserExample userExample = new UserExample();
        //Criteria criteria = userExample.createCriteria();
        List<User> userList = userMapper.selectByExample(userExample);
        System.out.println(userList.size());
    }
}
