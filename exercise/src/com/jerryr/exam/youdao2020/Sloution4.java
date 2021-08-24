package com.jerryr.exam.youdao2020;

public class Sloution4 {
    /**
     * @description:
     * 牛牛现在有一个包含 n 个正整数的数组 a ，
     * 牛牛可以将其中的每个数 a[i] 都拆成若干个和为 a[i] 的正整数，
     * 牛牛想知道拆后（也可以一个数都不拆）这个数组最多能有多少个素数。
     * 任何数都可以拆成2根3的组合，尽可能多的拆成2
     * @param
     * @return
     * @author: jerryr
     * @dateTime: 2021/8/20 16:55
     */
    public int maxNumOfPrime(int[] array){
        int maxNum = 0;
        for (int i = 0; i < array.length ; i++) {
            maxNum+=array[i]/2;
        }
        return maxNum;
    }
}
