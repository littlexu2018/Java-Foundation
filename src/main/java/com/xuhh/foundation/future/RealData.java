package com.xuhh.foundation.future;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这个相当于真正去数据库操作的类，模拟消耗时间比较长的任务
 */
public class RealData implements Data {
    public final String result;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public RealData(String result) {
        System.out.println("RealData start " + simpleDateFormat.format(new Date()));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(result);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("RealData end " + simpleDateFormat.format(new Date()));
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return null;
    }
}
