package com.jerryr.exam.youdao2020;

import java.util.Scanner;

public class Sloution3 {
    /**
     * @description:
     * 小易得到了一个仅包含大小写英文字符的字符串，该字符串可能不是回文串。
     * （“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串，“asds”就不是回文串。）
     *
     * 小易可以在字符串尾部加入任意数量的任意字符，使其字符串变成回文串。
     *
     * 现在请你编写一个程序，程序要能计算出小易可以得到的最短回文串。
     *
     * @param
     * @return
     * @author: jerryr
     * @dateTime: 2021/8/20 16:20
     */
    public static String minLengthString(String str){
        StringBuilder sb = new StringBuilder(str);
        if (isHuiwen(str)){
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            sb.insert(str.length(),str.charAt(i));
            if (isHuiwen(sb.toString()))
                break;
        }
        return sb.toString();
    }
    public static boolean isHuiwen(String str){
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(scanner.next());
        String str = Sloution3.minLengthString(sb.toString());
        System.out.println(str);

    }
}
