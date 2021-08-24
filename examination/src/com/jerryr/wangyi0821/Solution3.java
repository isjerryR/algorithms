package com.jerryr.wangyi0821;

import java.util.ArrayList;

public class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算最小航行费用
     * @param input int整型二维数组 二维网格
     * @return int整型
     */
    public int minSailCost (int[][] input) {
        int cost = dfs(input, 0, 0);
        return cost;
    }
    public int dfs(int[][] input,int i,int j){
        int cost = 0;
        if (i > input.length-1 || i < 0 || j > input[0].length-1 || j < 0)
            return -1;
        if (i == input.length-1 && j == input[0].length-1){
            cost = input[i][j];
            return cost;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (j+1 <= input[0].length-1 && input[i][j+1] != 2){
            cost = dfs(input,i,j+1) + input[i][j+1];
        }

        else if (i+1 <= input.length-1 && input[i+1][j] != 2)
            cost = dfs(input,i+1,j)+input[i+1][j];
        else if (i-1 >=0 && input[i-1][j] != 2)
            cost = dfs(input,i-1,j)+input[i-1][j];
        else if (j-1 >= 0 && input[i][j-1] != 2)
            cost = dfs(input,i,j-1)+input[i][j-1];
        else
            return -1;
        return cost;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        Solution3 solution3 = new Solution3();
        int cost = solution3.minSailCost(input);
        System.out.println(cost);
    }

}
