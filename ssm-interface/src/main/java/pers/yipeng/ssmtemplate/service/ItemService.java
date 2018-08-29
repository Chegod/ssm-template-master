package pers.yipeng.ssmtemplate.service;

import pers.yipeng.ssmtemplate.pojo.Items;

import java.util.List;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/3 16:45
 * @Version 1.0
 **/
public interface ItemService {
    List<Items> queryItemList();

    Items selectItemById(Integer id);

    void updateItem(Items items);
}
