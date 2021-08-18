package com.jerryr.search;
/**
 * 二分查找，查找的数组必须是有序的。
 * */

public class BinarySearch {
    //二分查找的递归形式
    public static int binarySearch(int[] array,int left,int right,int findVal){
        if (left > right){
            return -1;
        }
        int mid = (right + left)/2;
        int midVal = array[mid];
        if (findVal > midVal){
            return binarySearch(array,mid+1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(array,left,mid-1,findVal);
        }else {
            return midVal;
        }
    }

    //二分查找的非递归形式
    public static int binarySearchNoRecursion(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target){
                right = mid - 1;//向左查找
            }
            else
                left = mid + 1;
        }
        return -1;
    }
}


