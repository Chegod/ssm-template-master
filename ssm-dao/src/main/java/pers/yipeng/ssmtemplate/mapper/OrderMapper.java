package pers.yipeng.ssmtemplate.mapper;

import pers.yipeng.ssmtemplate.pojo.Order;
import pers.yipeng.ssmtemplate.pojo.OrderUser;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/6 22:27
 * @Version 1.0
 **/
public interface OrderMapper {
    //查询所有订单信息
    List<Order> queryOrderAll();
    //查询所有订单信息，关联查询下单用户信息。
    List<OrderUser> queryOrderUser();
}
