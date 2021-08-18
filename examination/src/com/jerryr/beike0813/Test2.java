package com.jerryr.beike0813;

public class Test2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param k int整型
     * @return string字符串
     */
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String sbdhfwqie = test2.NS_String("sbdhfwqiee", 3);
        System.out.println(sbdhfwqie);
    }
    public String NS_String(String s, int k) {
        // write code here
        boolean[] count = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] = true;
        }
        char ch = 'a';
        while (k > 0) {
            while (!count[ch - 'a']) {
                ++ch;
            }
            count[ch - 'a'] = false;
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a']) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
