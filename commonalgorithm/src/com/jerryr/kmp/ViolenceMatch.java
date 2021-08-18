package com.jerryr.kmp;

public class ViolenceMatch {
	public static void main(String[] args) {
		String str1 = "1234456879811005152468512012";
		String str2 = "45687";
		int index = violenceMatch(str1, str2);
		System.out.println(index);
	}

	/**
	 * @description: 暴力匹配字符串
	 * @param str1 第一个字符串
	 * @param str2 第二个字符串
	 * @return int 返回第二个字符串在第一个字符串第一次出现位置的索引
	 * @author: jerryr
	 * @dateTime: 2021/8/16 10:18
	 */
    public static int violenceMatch(String str1, String str2){
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();

		int s1length = chars1.length;
		int s2length = chars2.length;

		int i = 0;
		int j = 0;
		while (i < s1length && j < s2length){
			if (chars1[i] == chars2[j]){
				i++;
				j++;
			}else {
				i = i - (j -1);
				j = 0;
			}
		}
		if (j == s2length)
			return i-j;
		else
			return -1;
	}
}
