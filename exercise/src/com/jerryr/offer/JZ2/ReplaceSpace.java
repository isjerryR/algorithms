package com.jerryr.offer.JZ2;

public class ReplaceSpace {
    /**
     * @description:
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param s
     * @return java.lang.String
     * @author: jerryr
     * @dateTime: 2021/8/17 9:47
     */
    public String replaceSpace(String s){
        int length = s.length();
        char[] chars = new char[3*length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' '){
                chars[index ++] = '%';
                chars[index++] = '2';
                chars[index ++] = '0';
            }else
                chars[index ++] = s.charAt(i);
        }
        String newStr = new String(chars, 0, index);
        return newStr;
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String we_are_happy = replaceSpace.replaceSpace(" w e a r e h a p p y ");
        System.out.println(we_are_happy);
    }
}
