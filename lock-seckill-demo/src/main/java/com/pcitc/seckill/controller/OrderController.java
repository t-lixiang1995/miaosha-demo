package com.pcitc.seckill.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.pcitc.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @ClassName OrderController
 * @Description TODO
 * @Author pcitc
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;



    /**
     * @method 方法描述:通过无锁方式抢购
     * @author pcitc
     * @date  14:45
     * @param
     * @return java.util.List<ActivemqRestaurant>
     */
    @RequestMapping("/nolock")
    @ResponseBody
    public void nolock()throws Exception {

        orderService.seckillWithNoLock();
    }



    /**
     * @method 方法描述:通过乐观锁抢购,无重试
     * @author pcitc
     * @date  14:45
     * @param
     * @return java.util.List<ActivemqRestaurant>
     */
    @RequestMapping("/optimistic")
    @ResponseBody
    public void optimistic()throws Exception {

        orderService.seckillWithOptimistic();


    }

    /**
     * @method 方法描述:通过乐观锁实现抢购，有重试
     * @author pcitc
     * @date  14:45
     * @param
     * @return java.util.List<ActivemqRestaurant>
     */
    @RequestMapping("/optimisticWithRetry")
    @ResponseBody
    public void optimisticWithRetry()throws Exception {

       // orderService.seckillWithOptimistic();

        while (true){
            int i= orderService.seckillWithOptimistic();
            //如果卖光了 或者卖出成功跳出循环，否则一直循环 直到卖出去为止
            if(i==-1||i>0)
                break;

        }

    }


    /**
     * @method 方法描述:通过悲观锁抢购
     * @author pcitc
     * @date  14:45
     * @param
     * @return java.util.List<ActivemqRestaurant>
     */
    @RequestMapping("/pessimistic")
    @ResponseBody
    public void pessimistic()throws Exception {

        orderService.seckillWithPessimistic();
    }


    /**
     * @method 方法描述:通过redis原子操作
     * @author pcitc
     * @date  14:45
     * @param
     * @return java.util.List<ActivemqRestaurant>
     */
    @RequestMapping("/byRedis")
    @ResponseBody
    public void byRedis()throws Exception {

        orderService.seckillWithRedis();
    }


    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
        RateLimiter rateLimiter =RateLimiter.create(2);

        while (true){
            rateLimiter.acquire(1);
            System.out.println(simpleDateFormat.format(new Date()));
        }
    }




}
