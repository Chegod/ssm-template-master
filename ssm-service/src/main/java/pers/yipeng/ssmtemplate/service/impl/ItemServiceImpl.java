package pers.yipeng.ssmtemplate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pers.yipeng.ssmtemplate.mapper.ItemsMapper;
import pers.yipeng.ssmtemplate.pojo.Items;
import pers.yipeng.ssmtemplate.pojo.ItemsExample;
import pers.yipeng.ssmtemplate.service.ItemService;

import java.util.List;

/**
 * @ClassName ItemServiceImpl
 * @Description TODO
 * @Author eooy
 * @Date 2018/7/3 16:46
 * @Version 1.0
 **/
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> queryItemList() {
        ItemsExample itemsExample = new ItemsExample();
        List<Items> items = itemsMapper.selectByExample(itemsExample);
        return items;
    }

    @Override
    public Items selectItemById(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItem(Items items) {
        itemsMapper.updateByPrimaryKeySelective(items);
    }

}
