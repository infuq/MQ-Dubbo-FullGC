package com.infuq.facade.impl;


import com.infuq.facade.QueryUserInfoFacade;
import org.springframework.stereotype.Service;

@Service("queryUserInfoFacade")
public class QueryUserInfoFacadeImpl implements QueryUserInfoFacade {


    @Override
    public Object update(String address) {

        System.out.println("[Dubbo提供者]:" + Thread.currentThread().getName() + "执行Dubbo接口调用");

//        byte[] tmp = new byte[10 * 1024 * 1024];//10M

        try {
            Thread.sleep(1000_20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "调用成功";
    }
}
