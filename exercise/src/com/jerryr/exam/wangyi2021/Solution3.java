package com.jerryr.exam.wangyi2021;

public class Solution3 {
    /**
     * @description:
     * 已知摩尔斯电码和字符映射关系如下：
     * A -> 0
     * B -> 1
     * C -> 10
     * D -> 11
     * E -> 100
     * F -> 101
     * G -> 110
     * H -> 111
     * 当前我们获取到了一串01数字字符串，需要进行摩尔斯电码解码，请问共有多少种解码方法？
     *
     * @param
     * @return
     * @author: jerryr
     * @dateTime: 2021/8/21 10:01
     */
    public static int moresCode(String code){
        char[] chars = code.toCharArray();
        int len = chars.length;
        int[] dp = new int[len+1];
        dp[len] = 1;
        for (int i = len-1; i >= 0 ; i--) {
            dp[i] = dp[i+1];
            if (chars[i] == '1'){
                if (i + 2 <= len)
                    dp[i] += dp[i+2];
                if (i+3 <= len)
                    dp[i] += dp[i+3];
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        int code = moresCode("0100");
        System.out.println(code);
    }
}
