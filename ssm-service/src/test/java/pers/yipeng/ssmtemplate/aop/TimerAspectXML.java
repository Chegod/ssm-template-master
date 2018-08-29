package pers.yipeng.ssmtemplate.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimerAdvice
 * @Description 监控通知
 * @Author eooy
 * @Date 2018/8/6 15:56
 * @Version 1.0
 **/
public class TimerAspectXML {

    public Object logTimer(ProceedingJoinPoint thisJoinPoint) throws Throwable {

        MonitorTime monitorTime=new MonitorTime();
        //获取目标类名称
        String clazzName = thisJoinPoint.getTarget().getClass().getName();
        //获取目标类方法名称
        String methodName = thisJoinPoint.getSignature().getName();

        monitorTime.setClassName(clazzName);//记录类名称
        monitorTime.setMethodName(methodName);//记录对应方法名称
        monitorTime.setLogTime(new Date());//记录时间

        // 计时并调用目标函数
        long start = System.currentTimeMillis();
        Object result = thisJoinPoint.proceed();
        long time = System.currentTimeMillis() - start;

        //设置消耗时间
        monitorTime.setComsumeTime(time);
        //把monitorTime记录的信息上传给监控系统，并没有实现，需要自行实现即可
        //MonitoruUtils.report(monitorTime)
        System.out.println("日期"+monitorTime.getLogTime()+":"+monitorTime.getClassName()+"类"+monitorTime.getMethodName()+"方法，耗时"+monitorTime.getComsumeTime());
        return result;
    }
}
