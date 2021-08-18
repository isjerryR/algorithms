package com.jerryr.offer.JZ11;

public class NumOf1 {
    /**
     * @description:
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return int
     * @author: jerryr
     * @dateTime: 2021/8/17 15:34
     */
    public int NumberOf1(int n) {
        if (n == 0)
            return 0;
        int count = 0;
        while (n != 0){
            count+=n&1;
            n = n>>1;
        }
        return count;
    }

    public int NumberOf1II(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n&(n -1);
        }
        return count;
    }

}
