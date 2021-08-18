package com.jerryr.sort;
/**
 * 快速排序
 * 内部排序
 * 平均时间复杂度:O（nlogn）
 * 最坏时间复杂度：O（nlogn）
 * 空间复杂度：O（1）
 * 稳定性：不稳定
 *
 * */
public class QuickSort {
    public void quickSort(int[] arr,int low,int high){
        if (low >= high){
            return;
        }
        int i = low;
        int j = high;
        int base = arr[low];
        while (i < j){
            while ( base < arr[j] && i < j){
                j--;
            }
            while (base >= arr[i] && i<j){
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int current = arr[low];
        arr[low] = arr[j];
        arr[j] = current;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }
}
