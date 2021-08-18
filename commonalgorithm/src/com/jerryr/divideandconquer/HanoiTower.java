package com.jerryr.divideandconquer;

import java.time.Duration;
import java.time.Instant;

public class HanoiTower {
    public static void main(String[] args) {
        Instant start = Instant.now();
        hanoiTower(20,'A','B','C');
        Instant end = Instant.now();
        long l = Duration.between(start, end).toMillis();
        System.out.println(l);
    }

    //分治算法解决汉诺塔问题
    public static void hanoiTower(int num,char a,char b,char c){
        if (num == 1)
            System.out.println("第"+num+"个圆盘从"+a+"-->"+c);
        else {
            hanoiTower(num - 1,a,c,b);
            System.out.println("第"+num+"个圆盘从"+a+"-->"+c);
            hanoiTower(num-1,b,a,c);
        }
    }
}
