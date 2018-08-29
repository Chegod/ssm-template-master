package pers.yipeng.ssmtemplate.aop;

/**
 * @ClassName TargetObject
 * @Description TODO
 * @Author eooy
 * @Date 2018/8/6 16:27
 * @Version 1.0
 **/
public class TargetObject {
    public void sleep1000ms(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sleep2000ms(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sleep3000ms(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
