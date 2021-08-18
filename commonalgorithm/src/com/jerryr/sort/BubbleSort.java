package com.jerryr.sort;
/**
 * 冒泡排序，
 * 内部排序
 * 平均时间复杂度:O（n2）
 * 最坏时间复杂度：O（n2）
 * 空间复杂度：O（1）
 * 稳定性：稳定
 *
 * */
public class BubbleSort {
    public int[] bubbleSort(int[] arr){
        int length = arr.length;
        if (length > 0 && length != 1){
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }

        return arr;
    }

    //优化冒泡排序：若第i趟冒泡并没有进行交换数据，说明数据已经是有序的，无需进行下次冒泡
    public int[] optimizationOfBubbleSort(int[] arr){
        int length = arr.length;

        if (length > 0 && length != 1){
            boolean flag = false;//标识变量，表示是否进行过交换
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (arr[j] > arr[j+1]){
                        flag = true;
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
                if (!flag)//没有进行过交换
                    break;
                else
                    flag = true;//重置flag。进行下一次冒泡循环
            }
        }

        return arr;
    }
}
