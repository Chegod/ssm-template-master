package pers.yipeng.ssmtemplate.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MonitorTime
 * @Description 性能监控信息类，简单模拟
 * @Author eooy
 * @Date 2018/8/6 15:52
 * @Version 1.0
 **/
public class MonitorTime {
    private String className;
    private String methodName;
    private Date logTime;
    private Long comsumeTime;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getLogTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(logTime);
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Long getComsumeTime() {
        return comsumeTime;
    }

    public void setComsumeTime(Long comsumeTime) {
        this.comsumeTime = comsumeTime;
    }
}
