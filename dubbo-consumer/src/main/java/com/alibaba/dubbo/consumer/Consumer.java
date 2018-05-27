package com.alibaba.dubbo.consumer;
import com.alibaba.dubbo.demo.DemoService;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Consumer {
    public static void main(String[] args) throws Exception {
        //测试常规服务
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("consumer start");
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            DemoService demoService = context.getBean(DemoService.class);
            System.out.println("consumer");
            System.out.println(demoService.getPermissions(1L));
            Thread.sleep(r.nextInt(5000));
		}
        System.out.println("consumer end");
        System.in.read();
    }
}