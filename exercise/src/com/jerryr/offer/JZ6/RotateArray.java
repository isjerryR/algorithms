package com.jerryr.offer.JZ6;

public class RotateArray {
    /**
     * @description:
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return int
     * @author: jerryr
     * @dateTime: 2021/8/17 14:54
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null)
            return 0;
        if (array.length == 1){
            return array[0];
        }
        int index = array.length-1;
        while (index >= 1 && array[index] >= array[index - 1]){
            index--;
        }
        return array[index];
    }
}
