package com.jerryr.sort;
/**
 * 希尔排序
 * 内部排序
 * 平均时间复杂度:O（nlogn）
 * 最坏时间复杂度：O（nlogn）
 * 空间复杂度：O（1）
 * 稳定性：不稳定
 *
 * */
public class ShellSort {
    public int[] shellSort(int[] arr){
       if (arr.length > 0){
           int len = arr.length;
           int gap = len / 2;
           while (gap > 0){
               //每组进行插入排序
               for (int i = gap; i < arr.length; i++) {
                   int temp = arr[i];
                   int index = i - gap;
                   while (index >= 0 && temp < arr[index]) {
                       arr[index + gap] = arr[index];
                       index -= gap;
                   }
                   arr[index + gap] = temp;
               }
               gap /=2;
           }
       }
       return arr;
    }
}
