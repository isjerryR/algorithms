package com.jerryr.wangyi0821;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(" ");
        int[] array = new int[arr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        int nums = numsOfPaper(array);
        System.out.println(nums);
    }
    public static int numsOfPaper(int[] array) {
        int[] nums = new int[array.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }
        if (array[0] > array[array.length-1])
            nums[0]+=1;
        if (array[0] < array[array.length-1])
            nums[nums.length-1]+=1;
        for (int i = 1; i < nums.length; i++) {
            if (array[i] >array[i-1])
                nums[i]=nums[i-1]+1;
        }
        for (int i = nums.length-2; i >= 0 ; i--) {
            if (array[i] > array[i+1] && nums[i] <= nums[i+1])
                nums[i]=nums[i+1]+1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            System.out.print(nums[i]+" ");
        }
        return sum;
    }
}
