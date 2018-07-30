package com.my.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @create 2018-07-30 10:07
 */
@Service
public class ScheduService {

    //cron语法基本格式为，以空格分隔的6个字符串，一次代表：秒 分 小时 日期 月份 星期，具体如下：
    //字段    允许值     允许的特殊字符
    //秒      0-59       ,- * /
    //分      0-59       ,- * /
    //时      0-23       ,- * /
    //日期    1-31       ,- * / ? L W C
    //月份    1-12       ,- * /
    //星期    0-7或者SUN-SAT, 0,7是SUN   ,- * ? / L C #

    //特殊字符的含义：
    //  ,   枚举
    //  -   区间
    //  *   任意
    //  /   步长
    //  ?   日/星期冲突匹配
    //  L   最后
    //  W   工作日
    //  C   和calendar联系后计算过的值
    //  #   星期,4#2,第二个星期四
    //@Scheduled(cron = "0 * * * * MON-FRI") 每个月周一到周五每天每小时每分钟的0秒执行一次
    //@Scheduled(cron = "0 0 21 L * ?")//每个月的最后一天21点执行一次
    //其他例子
    //0 0-5 14,18 * * ?  每个月每天14点整和18点整，每隔5分钟执行一次
    //0 15 10 ? * 1-6 每月周一到周六每天10:15执行一次
    //0 0 2 ? * 6L 每月的最后一个周六2点执行一次
    //0 0 2 LW * ? 每月的最后一个工作日凌晨2点执行一次
    //0 0 2-4 ? * 1#1  每月第一个周一的2点到4点之间，每个0分0秒执行一次
    @Scheduled(cron = "0-4 * * * * 1-6")
    public void sayHi() throws Exception{
        //Thread.sleep(6);
        System.out.println("hi,Bruce");

    }

}
