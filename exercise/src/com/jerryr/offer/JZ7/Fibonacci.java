package com.jerryr.offer.JZ7;

public class Fibonacci {
    /**
     * @description:
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n\leq 39n≤39
     * @param n
     * @return int
     * @author: jerryr
     * @dateTime: 2021/8/17 15:02
     */
    public int Fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
