package com.jerryr.exam.youdao2020;

import java.util.Scanner;

public class Sloution2 {
    /**
     * @description:
     * 小易参加了一次考试，这场包含 n 个题目，第 i 个题目的分数是 si 。
     *
     * 如果小易第 i 题目回答正确，他将得到 Si 分，否则该题目他将得到 0 分。
     *
     * 最终的考试得分是所有题目得分的总和。
     *
     * 由于阅卷老师很讨厌数字 5，在阅卷时如果一个学生的考试总分中含有数字 5，那么阅卷老师将气愤地给他 0 分。
     *
     * 那么小易考试的最高得分是多少？
     *
     * 输入的第一行是正整数 n(1<=n<=100)  ，代表这场考试的题目数。
     * 接下一行含有n个正整数 s1,s2,s3....sn (1<= si <=200)
     * 输出一个整数，代表小易考试的最高得分。
     *
     * @param
     * @return
     * @author: jerryr
     * @dateTime: 2021/8/20 15:04
     */
    public int mostScore(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] si = new int[n];
        int score = 0;
        for (int i = 0; i < si.length; i++) {
            si[i] = scanner.nextInt();
            score+=si[i];
        }
        if (n == 1){
            if (score == 5)
                return 0;
            return score;
        }
        boolean containFive = isContainFive(score);
        if (containFive) {
            for (int i = 0; i < si.length; i++) {
                for (int j = 0; j < si.length - i - 1; j++) {
                    if (si[j] > si[j + 1]) {
                        int temp = si[j];
                        si[j] = si[j + 1];
                        si[j + 1] = temp;
                    }
                }
            }
            int maxScore = score;
            for (int i = 0; i < si.length; i++) {
                maxScore = maxScore - si[i];
                if (!isContainFive(maxScore))
                    return maxScore;
            }
        }
        return score;
    }
    public boolean isContainFive(int maxScore){
        while (maxScore > 0 ){
            if (maxScore%10 == 5)
                return true;
            maxScore = maxScore/10;
        }
        return false;
    }

    public static void main(String[] args) {
        Sloution2 sloution2 = new Sloution2();
        int i = sloution2.mostScore();
        System.out.println(i);
    }
}
