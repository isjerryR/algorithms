package com.jerryr.exam.wangyi2021;

import java.util.Scanner;

public class Solution1 {
    /**
     * @description:
     * A公司和B公司有n个合作的子项目，每个子项目由A公司和B公司各一名员工参与。一名员工可以参与多个子项目。
     *
     * 一个员工如果担任了该项目的项目经理，它需要对所参与的该项目负责。一个员工也可以负责多个项目。
     *
     * A公司和B公司需要保证所有子项目都能有人负责，问最少需要指定几名项目经理？
     * 输入：
     * 第一行为A公司的的人员id列表， 0< id数量 < 10000，用空格切分
     * 第二行为B公司的人员id列表， 0< id数量 < 10000，用空格切分
     * 第三行为有已经有多少个匹配数子项目合作关系n
     * 下面有n行，每一行为每个子项目的合作对应关系，为两个id，第一个为A公司的员工id，第二个为B公司的员工id，用空格区分
     * 输出：
     * 一个整数，A公司和B公司合起来至少需要指定几名项目经理
     *
     * @param
     * @return
     * @author: jerryr
     * @dateTime: 2021/8/20 17:20
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] aid;
        int[] bid;
        int num;
        int[][] current;
    }

}
