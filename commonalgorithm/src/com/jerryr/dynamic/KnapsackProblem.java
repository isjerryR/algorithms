package com.jerryr.dynamic;

public class KnapsackProblem {
    /**
     * @param w 物品重量
     * @param value 物品价值
     * @param m 背包容量
     * @return 返回背包装入物品总价值的最大值
     * */
    public static int knapsackProblem(int[] w,int[] value,int m){
        int n = value.length;//物品的个数
        int[][] v = new int[n+1][m+1];//v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path = new int[n+1][m+1];
        //初始化第一行和第一列,数组创建默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i-1] > j)
                    v[i][j] = v[i - 1][j];
                else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if-else来体现公式
                    if(v[i - 1][j] < value[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //从path的最后开始找
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }
        return v[n][m];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1,4,3};
        int[] value = new int[]{1500,3000,2000};
        int m = 4;
        int values = knapsackProblem(w, value, m);
        System.out.println(values);
    }


}
