package com.jerryr.offer.JZ12;

public class Power {
    /**
     * @description:
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。
     * @param base
     * @param exponent
     * @return double
     * @author: jerryr
     * @dateTime: 2021/8/17 15:57
     */
    public static double Power(double base, int exponent) {
        if (base == 0 || base == 1)
            return base;
        if (exponent == 0)
            return 1;
        else if (exponent > 0){
            double temp = base;
            for (int i = 0; i < exponent-1; i++) {
                base *= temp;
            }
        }else {
            double temp = base;
            base = 1;
            for (int i = 0; i < -exponent; i++) {
                base /= temp;
            }
        }
        return base;
    }

    public static void main(String[] args) {
        double power = Power(2.0, -8);
        System.out.println(power);
    }
}
