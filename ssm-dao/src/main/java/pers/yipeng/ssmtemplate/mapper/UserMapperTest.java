package pers.yipeng.ssmtemplate.mapper;


import pers.yipeng.ssmtemplate.pojo.QueryVo;
import pers.yipeng.ssmtemplate.pojo.User;
import pers.yipeng.ssmtemplate.pojo.UserTest;

import java.util.List;

public interface UserMapperTest {
   UserTest selectUserById(Integer id);

   List<UserTest> fuzzyQueryUser(String str);

   List<UserTest> selectUserByQueryVo(QueryVo queryVo);

   void insertUser(UserTest userTest);

   void insertUserIncrUUID(UserTest userTest);

   void   updateUserById(UserTest userTest);

   void  deleteUserById(UserTest userTest);
}