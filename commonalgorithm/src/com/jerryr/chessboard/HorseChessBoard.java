package com.jerryr.chessboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessBoard {
    private static int X;//棋盘的列数
    private static int Y;//棋盘的行数
    private static boolean visited[];
    private static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    public static void traversalChessboard(int[][] chessboard,int row,int column,int step){
        chessboard[row][column] = step;
        visited[row * X + column] = true;
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()){
            Point p = ps.remove(0);//取出下一个可以走的位置
            if (!visited[p.y * X + p.x]){
                traversalChessboard(chessboard,p.y,p.x,step+1);
            }
        }
        if (step < X*Y && !finished){
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        }else   {
            finished = true;
        }
    }

    /**
     * 功能： 根据当前位置(Point对象)，计算马儿还能走哪些位置(Point)，并放入到一个集合中(ArrayList), 最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }
    /**
     * @description: 根据当前这个点的下一步的所有下一步可选择的位置进行非递减排序，减少回溯次数
     * @param ps
     * @return void
     * @author: jerryr
     * @dateTime: 2021/8/17 9:10
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(Comparator.comparingInt(o -> next(o).size()));
    }
}
