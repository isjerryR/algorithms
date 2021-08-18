package com.jerryr.sort;

import java.util.ArrayList;

/**
 * 基数排序
 * 内部排序
 * 平均时间复杂度:O（nlogn）
 * 最坏时间复杂度：O（nlogn）
 * 空间复杂度：O（1）
 * 稳定性：不稳定
 *
 * */
public class RadixSort {
    public static int[] radixSort(int[] arr){
        if (arr == null || arr.length<2){
            return arr;
        }
        //1.先计算出最大数的位数
        int max = arr[0];//最大数
        int maxDigit = 0;//最大数的位数
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        //方式一
        while (max != 0){
            max /=10;
            maxDigit++;
        }
//        //方式二：
//        maxDigit = (max+"").length();
        //2.分桶
        int mod = 10;
        int div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();//创建二维可变数组（准备十个桶）
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        //3。装数据
        for (int i = 0; i < maxDigit; i++,mod *= 10 , div *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mod) / div;
                bucketList.get(num).add(arr[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    arr[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }

        return arr;
    }
}
