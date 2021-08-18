package com.jerryr.sort;
/**
 * 选择排序
 * 内部排序
 * 平均时间复杂度:O（n2）
 * 最坏时间复杂度：O（n2）
 * 空间复杂度：O（1）
 * 稳定性：不稳定
 *
 * */
public class SelectionSort {
    public int[] selectionSort(int[] arr){
        if (arr.length > 0){
            for (int i = 0; i < arr.length; i++) {
                int index = i;
                for (int j = index; j < arr.length; j++) {
                    if (arr[index] > arr[j]){
                        index = j;
                    }
                }
                if (index != i){
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
