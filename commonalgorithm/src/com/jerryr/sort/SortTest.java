package com.jerryr.sort;

import org.junit.Test;

public class SortTest {
//    int[] arr = new int[]{9,8,7,5,4,6,3,2,1};
    private static final int[] arr;
    static {
//        arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random()*80000);
//        }
        arr = new int[]{9,2,1,0,4,2,6,7};
    }
    @Test
    public void test(){
        InsertionSort insertionSort = new InsertionSort();
        int[] ints = insertionSort.insertionSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void testShell(){
        ShellSort shellSort = new ShellSort();
        int[] ints = shellSort.shellSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    @Test
    public void testQuickSort(){
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    @Test
    public void testMergeSort(){
        int[] ints = MergeSort.mergeSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    @Test
    public void testRadixSort(){
        int[] ints = RadixSort.radixSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    @Test
    public void testHeapSort(){
        int[] ints = HeapSort.heapSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    @Test
    public void testBubbleSort(){
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.bubbleSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
