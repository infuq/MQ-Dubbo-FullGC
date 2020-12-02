package com.infuq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DubboProvider {

    public static void main(String[] args) {

        try {

            ApplicationContext context = new ClassPathXmlApplicationContext("DubboProvider.xml");

            System.out.println("Dubbo提供者启动成功...");

            System.in.read();

        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }


}
