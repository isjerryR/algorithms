package com.jerryr.sort;
/**
 * 插入排序
 * 内部排序
 * 平均时间复杂度:O（n2）
 * 最坏时间复杂度：O（n2）
 * 空间复杂度：O（1）
 * 稳定性：稳定
 *
 * */
public class InsertionSort {
    public int[] insertionSort(int[] arr){
        if (arr.length > 0){
            for (int i = 1; i < arr.length; i++) {
                int insertVal = arr[i];
                int insertIndex = i - 1;
                while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                    arr[insertIndex + 1] = arr[insertIndex];
                    insertIndex--;
                }
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }

}
