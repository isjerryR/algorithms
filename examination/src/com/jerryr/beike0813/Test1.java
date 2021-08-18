package com.jerryr.beike0813;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        long[] longs = test1.FarmerNN(4, 6);
        for (long aLong : longs) {
            System.out.println(aLong);
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param m long长整型
     * @return long长整型一维数组
     */
    public long[] FarmerNN (int n, long m) {
        // write code here
//        long[] ans = new long[n];
//        if (n > m){
//            for (int i = 0; i < m; i++) {
//                ans[i] += 1;
//            }
//        }else {
//            long x = (m -n)/(n -1);
//            long y = (m - n)%(n - 1);
//            for (int i = 0; i < n; i++) {
//                ans[i] = x;
//            }
//            if (x%2==0){
//                ans[0] = ans[n-1] = x/2;
//                for (long i = 0; i < y; i++) {
//                    ans[(int) i] += 1;
//                }
//            }else {
//                ans[0] = ans[n -1] = (x-1)/2;
//                for (int i = 0; i < n - 1; i++) {
//                    ans[i] += 1;
//                }
//                for (long i = 0; i < y; i++) {
//                    ans[(int) (n-1-i)] += 1;
//                }
//            }
//        }
//        return ans;
        long[] ans = new long[n];
        if (n>=m){
            for (int i = 0; i < ans.length; i++) {
                ans[i] += 1;
            }
        }
        long x = (m-n)/((n-1)*2);
        long y = (m-n)%((n-1)*2);
        ans[0] = ans[n-2] = x+1;
        for (int i = 1; i < ans.length - 1; i++) {
            ans[i]+= x*2 + 1;
        }
        if (y <= n-1){
            int index = n-2;
            while (index >= 0 && y > 0){
                ans[index]+=1;
                y--;
                index--;
            }
        }else {
            for (int i = 0; i < n - 1; i++) {
                ans[i] += 1;
            }
            int index = 0;
            while (index <= y-(n -1)){
                ans[index] += 1;
                index++;
            }
        }
        return ans;

    }
}
