package com.xuhh.foundation.future;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public  Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run(){
                System.out.println("run start " + simpleDateFormat.format(new Date()));
                RealData realData = new RealData(queryStr);
                System.out.println("run end " + simpleDateFormat.format(new Date()));
                future.setRealData(realData);
            }
        }.start();
        //立即返回futureData
        return future;
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        Client client = new Client();
        //返回的futureData
        Data data = client.request("xxxx");
        System.out.println("请求完成");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println("真实数据"+data.getResult());
    }

}

