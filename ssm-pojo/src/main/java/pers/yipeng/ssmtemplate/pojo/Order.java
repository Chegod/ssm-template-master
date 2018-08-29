package pers.yipeng.ssmtemplate.pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/6 22:23
 * @Version 1.0
 **/
public class Order implements Serializable {
    // 订单id
    private int id;
    // 用户id
    private Integer userId;
    // 订单号
    private String number;
    // 订单创建时间
    private Date createtime;
    // 备注
    private String note;

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCreatetime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatcreatetime= format.format(createtime);
        return formatcreatetime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
