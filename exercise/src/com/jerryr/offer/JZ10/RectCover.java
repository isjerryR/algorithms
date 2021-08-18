package com.jerryr.offer.JZ10;

public class RectCover {
    /**
     * @description:
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
     * 从同一个方向看总共有多少种不同的方法？
     *
     * 比如n=3时，2*3的矩形块有3种不同的覆盖方法(从同一个方向看)：
     * @param target
     * @return int
     * @author: jerryr
     * @dateTime: 2021/8/17 15:18
     */
    public int rectCover(int target) {
        if (target == 0 || target == 1 || target == 2)
            return target;
        return rectCover(target-1)+rectCover(target-2);
    }
}
