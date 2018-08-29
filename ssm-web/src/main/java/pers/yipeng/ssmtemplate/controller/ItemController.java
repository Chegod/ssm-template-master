package pers.yipeng.ssmtemplate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pers.yipeng.ssmtemplate.pojo.Items;
import pers.yipeng.ssmtemplate.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName ItemController
 * @Description TODO
 * @auuthor eooy
 * @Date 2018/7/3 16:22
 * @Version 1.0
 **/
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    //接收editItem.jsp中提交的表单数据,更新商品
    @RequestMapping(value = "/updateitem", method = RequestMethod.POST)
    public String updateItem(Items items) {
        itemService.updateItem(items);
        return "success";
    }

    //根据id查询商品
    @RequestMapping(value = "/itemEdit")
    public String selectItemById(@RequestParam(value = "id", required = true, defaultValue = "1") Integer id, HttpServletRequest request, Model model) {
        Items item = itemService.selectItemById(id);
        model.addAttribute("item", item);
        return "editItem";
    }


    //拦截的是web工程下的路径
    @RequestMapping(value = "/")
    public String queryItemList(Model model) {
        List<Items> items = itemService.queryItemList();
        model.addAttribute("itemList", items);
        return "itemList";
    }
}
