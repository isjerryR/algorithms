package com.jerryr.wangyi0821;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] array = new int[arr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        int m = scanner.nextInt();
        int nums = nums(array, m);
        System.out.println(nums);
    }
    public static int nums(int[] array,int m){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]+array[j] < m)
                    count++;
            }
        }
        return count;
    }
}
