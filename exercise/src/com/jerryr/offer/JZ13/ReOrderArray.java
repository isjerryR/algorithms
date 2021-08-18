package com.jerryr.offer.JZ13;

import java.util.Arrays;

public class ReOrderArray {
    /**
     * @description:
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     * @return int[]
     * @author: jerryr
     * @dateTime: 2021/8/17 16:13
     */
    public static int[] reOrderArray (int[] array) {
        // write code here
        int[] temp = new int[array.length];
        int pre = 0;
        int after = temp.length-1;
        int preIndex = 0;
        int sufIndex = temp.length-1;
//        while (pre <= temp.length-1 && after >= 0){
//            if (array[pre]%2!=0)
//                temp[preIndex++] = array[pre];
//            if (array[after]%2 == 0)
//                temp[sufIndex--] = array[after];
//            pre++;
//            after--;
//        }
        while (pre <= temp.length-1) {
            if (array[pre] % 2 != 0)
                temp[preIndex++] = array[pre];
            pre++;
        }
        while (after >= 0){
            if (array[after]%2 == 0)
                temp[sufIndex--] = array[after];
            after--;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,5,7};
        int[] ints = reOrderArray(arr);
        System.out.println(Arrays.toString(ints));
    }
}
