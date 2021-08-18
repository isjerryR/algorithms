package com.jerryr.kmp;

public class KMPAlgorithm {
    /**
     * @description: 获取一个字符串（子串）的部分匹配表
     * @param dest  目标字符串
     * @return int[]    返回字符串匹配表数组
     * @author: jerryr
     * @dateTime: 2021/8/16 10:50
     */
    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1,j = 0; i < dest.length() ; i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){//不相等往回寻找最大公共前后缀;
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j))//相等时，匹配值+1
                j++;
            next[i] = j;
        }
        return next;
    }
    /**
     * @description: TODO
     * @param mainString 待匹配的主字符串
	 * @param pattenString  匹配的模式字符串
     * @return int 若主字符串中包含模式字符串返回模式字符串第一个字符在主字符串中的索引位置，若不存在返回-1
     * @author: jerryr
     * @dateTime: 2021/8/16 15:02
     */
    public static int kmpSearch(String mainString,String pattenString){
        int[] next = kmpNext(pattenString);
        for (int i = 0,j = 0; i < mainString.length(); i++) {
            while (j > 0 && mainString.charAt(i) != pattenString.charAt(j))
                j = next[j - 1];
            if (mainString.charAt(i) == pattenString.charAt(j))
                j++;
            if (j == pattenString.length())
                return i - j + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String mainString  = "abcdfghtjsdfowehrfn";
        String pattenString = "abcdf";
        int index = kmpSearch(mainString, pattenString);
        System.out.println(index);
    }
}
