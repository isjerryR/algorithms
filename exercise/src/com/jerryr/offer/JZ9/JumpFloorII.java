package com.jerryr.offer.JZ9;

public class JumpFloorII {
    /**
     * @description:
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法。
     * @param target
     * @return int
     * @author: jerryr
     * @dateTime: 2021/8/17 15:13
     */
    public int jumpFloorII(int target) {
        if (target == 0 || target == 1)
            return target;
        return jumpFloorII(target - 1)*2;
    }
}
