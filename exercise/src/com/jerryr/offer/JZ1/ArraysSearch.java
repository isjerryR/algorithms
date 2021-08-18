package com.jerryr.offer.JZ1;

import org.junit.Test;

public class ArraysSearch {
    /**
     * @description:
     * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     * 给定 target = 7，返回 true。
     *
     * 给定 target = 3，返回 false。
     *
     * 0 <= array.length <= 500
     * 0 <= array[0].length <= 500
     * @param target
	 * @param array
     * @return boolean
     * @author: jerryr
     * @dateTime: 2021/8/17 9:29
     */
    public boolean Find(int target,int[][] array){
        int rows = array.length;
        int columns = array[0].length;
        if (rows == 0 || columns == 0)
            return false;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0){
            if (array[row][column] == target)
                return true;
            else if (array[row][column] < target)
                row++;
            else
                column--;
        }
        return false;
    }
    @Test
    public void findTest(){
        int target = 15;
        int[][] array = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        ArraysSearch arraysSearch = new ArraysSearch();
        boolean find = arraysSearch.Find(target, array);
        System.out.println(find);

    }
}
