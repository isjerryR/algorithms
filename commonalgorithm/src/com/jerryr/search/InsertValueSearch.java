package com.jerryr.search;
/**
 * 线性插值查找法，保证数组有序，适用于数组元素差值比较均匀的数组，否则查找效率不如二分查找
 * */
public class InsertValueSearch {
    public static int insertValueSearch(int[] array,int left,int right,int findValue){
        if (left > right || findValue < array[0] || findValue > array[array.length - 1]){
            return -1;
        }
        int mid = left + (right - left)*(findValue - array[left])/(array[right] - array[left]);
        int midValue = array[mid];
        if (findValue > array[mid]){
            return insertValueSearch(array,mid+1,right,findValue);
        }else if (findValue < array[mid]){
            return insertValueSearch(array,left,mid-1,findValue);
        }else {
            return midValue;
        }
    }
}
