package pers.yipeng.ssmtemplate.jdbc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;

/**
 * @ClassName JDBCTest
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/6 21:45
 * @Version 1.0
 **/
public class JDBCTest {
    private SqlSessionFactory sqlSessionFactory = null;
    @Test
    public void test1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvc?characterEncoding",
                    "root", "741953");
            PreparedStatement pst = connection.prepareStatement("select * from items where id = ?");
            pst.setObject(1,1);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getObject("id"));
                System.out.println(resultSet.getObject("name"));
                System.out.println(resultSet.getObject("price"));
                System.out.println(resultSet.getObject("detail"));
                System.out.println(resultSet.getObject("pic"));
                System.out.println(resultSet.getObject("createtime"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
