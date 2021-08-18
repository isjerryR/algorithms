package com.jerryr.sort;

import java.util.Arrays;

public class MergeSort {

//    public static void mergeSort(int[] arr,int left,int right,int[] temp){
//        if (left < right){
//            int mid = (left + right)/2;
//            mergeSort(arr,left,mid,temp);
//            mergeSort(arr,mid+1,right,temp);
//            merge(arr,left,mid,right,temp);
//        }
//    }
//
//    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
//        int i = left;
//        int j = mid + 1;
//        int t = 0;
//
//        while (i <= mid && j <= mid){
//            if(arr[i] <= arr[j]){
//                temp[t] = arr[i];
//                t += 1;
//                i += 1;
//            }else {
//                temp[t] = arr[j];
//                t += 1;
//                j += 1;
//            }
//            while ( i <= mid){
//                temp[t] = arr[i];
//                t += 1;
//                i += 1;
//            }
//            while (j >= right){
//                temp[t] = arr[j];
//                t += 1;
//                j += 1;
//            }
//            t=0;
//            int templeft = left;
//            while (templeft <= right){
//                arr[templeft] = temp[t];
//                t +=1;
//                templeft +=1;
//            }
//        }
//    }
//
    public static int[] mergeSort(int[] arr){
        if (arr.length < 2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length + right.length];
        for (int index = 0,i = 0,j = 0; index < result.length; index++) {
            if (i >= left.length){
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = left[i++];
            }else if (left[i] > right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return result;

    }

//    /**
//     * 2路归并算法
//     * @param array
//     * @return
//     */
//    public static int[] mergeSort(int[] array){
//        if(array.length < 2){
//            return array;
//        }
//        int mid = array.length /2;
//        int[] left = Arrays.copyOfRange(array, 0, mid);
//        int[] right = Arrays.copyOfRange(array, mid, array.length);
//        return merge(mergeSort(left),mergeSort(right));
//    }
//
//    public static int[] merge(int[] left,int[] right){
//        int[] result = new int[left.length + right.length];
//        for(int index = 0,i = 0, j = 0;index < result.length;index++){
//            if(i >= left.length){
//                result[index] = right[j++];
//            }else if(j >= right.length){
//                result[index] = left[i++];
//            }else if(left[i] > right[j]){
//                result[index] = right[j++];
//            }else{
//                result[index] = left[i++];
//            }
//        }
//        return result;
//
//    }

}
