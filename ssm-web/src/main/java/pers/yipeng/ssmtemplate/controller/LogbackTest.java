package pers.yipeng.ssmtemplate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Logback
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/23 17:20
 * @Version 1.0
 **/
@Controller
public class LogbackTest {
   private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

   @RequestMapping(value = "/logtest")
   public Object loggerTest(HttpServletResponse response) throws IOException {
      try{
         int a=1/0;
      }catch (Exception e){
         e.printStackTrace();
         logger.info("系统异常信息",e);
         response.getWriter().write(e.toString());
      }
      return null;
   }

   @RequestMapping(value = "/logerror")
   public Object loggerTestError(HttpServletResponse response) throws IOException {
      response.setContentType("text/html;charset=UTF-8");
      Integer i=0;
      while (true){
         i = i + 1000;
         response.getWriter().write("内存溢出没？"+i);
      }
   }

}
