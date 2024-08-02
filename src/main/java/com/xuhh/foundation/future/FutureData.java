package com.xuhh.foundation.future;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FutureData implements Data {
    public RealData realData = null;
    public boolean isReady = false;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public synchronized void setRealData(RealData realData){
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        this.notifyAll();    //realData已经被注入 通知getResult启动
    }


    @Override
    public synchronized String getResult() {
        while (!isReady){
            try {
                System.out.println("wait start " +  simpleDateFormat.format(new Date()));
                this.wait();     //等待realData被注入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("wait end " + simpleDateFormat.format(new Date()));
        return realData.result;
    }
}
