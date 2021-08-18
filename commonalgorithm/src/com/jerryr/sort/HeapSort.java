package com.jerryr.sort;

public class HeapSort {

    public static int[] heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        for (int i = arr.length-1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,i);
        }
        return arr;
    }

    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];//取出当前元素值，保存到临时变量
        //开始调整，k是i的左子节点
        for (int k=i*2+1; k < length; k = k*2+1) {
            //左子节点的值小于右子节点的值，对右子节点进行调整
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){//子节点的值大于父节点
                arr[i] = arr[k];//交换父子节点的值
                i = k;//调整后的子节点，需要继续调整成大顶堆。
            }else
                break;
        }
        arr[i] = temp;//temp值放到调整后的位置
    }
}
