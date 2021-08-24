package com.jerryr.wangyi0821;

public class Solution2 {
    public char findKthBit (int n, int k) {
        // write code here
        String sn = stringN(n);
        return sn.charAt(k-1);
    }
    public String invert(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((char)('z'-str.charAt(i)+'a'));
        }
        return sb.toString();
    }

    public String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public String stringN(int n){
        String[] sn = new String[n];
        sn[0] = "a";
        for (int i = 1; i < n; i++) {
            sn[i] = sn[i-1]+(char)('a'+i)+reverse(invert(sn[i-1]));
        }
        return sn[n-1];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        char kthBit = solution2.findKthBit(3, 1);
        System.out.println(kthBit);
    }
}
