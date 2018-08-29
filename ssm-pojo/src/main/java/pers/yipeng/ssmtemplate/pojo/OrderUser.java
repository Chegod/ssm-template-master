package pers.yipeng.ssmtemplate.pojo;

/**
 * @ClassName OrderUser
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/7 16:57
 * @Version 1.0
 **/
public class OrderUser extends Order {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
