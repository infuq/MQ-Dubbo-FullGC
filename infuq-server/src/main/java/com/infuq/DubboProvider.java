package com.infuq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DubboProvider {

    public static void main(String[] args) {

        try {

            // 使用D:\Soft\arthas\arthas-boot.jar工具查看线程信息
            ApplicationContext context = new ClassPathXmlApplicationContext("DubboProvider.xml");

            System.out.println("Dubbo提供者启动成功...");

            System.in.read();

            // invoke com.infuq.facade.QueryUserInfoFacade.update("2020")

        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }


}
