package com.jerryr.exam.wangyi2021;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {
    /**
     * @description:
     * 疫情逐步缓和后，电影院终于开业了，但是由于当前仍处于疫情期间，应尽量保持人群不聚集的原则。
     * 所以当小易来电影院选定一排后，尽量需要选择一个远离人群的位置。
     * 已知由0和1组成的数组表示当前排的座位情况,其中1表示已被选座，0表示空座
     * 请问小易所选座位和最近人的距离座位数最大是多少？
     * 有如下假设：至少有一个人已选座，至少有一个空座位，且座位数限制为
     * @param
     * @return
     * @author: jerryr
     * @dateTime: 2021/8/20 18:07
     */
    public static void main(String[] args) {

    }
    public static int maxDistance(Integer[] array){
        int[] disArray = new int[array.length];
        int headIndex = 0;
        int taiIndex = 0;
        int distance = taiIndex-headIndex;
        int maxDistance = distance;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || i == array.length - 1){
                taiIndex = i;
                maxDistance = Math.max(distance,taiIndex-headIndex);
                distance = taiIndex - headIndex;
                disArray[index++] = distance;
                headIndex = taiIndex;
            }
        }
        if (array[0] == 1 && array[array.length-1] == 1)
            return maxDistance/2;
        else if (array[0] == 1 && array[array.length-1] == 0)
            return Math.max(maxDistance/2,disArray[index-1]);
        else if (array[0] == 0 && array[array.length-1] == 1)
            return Math.max(maxDistance/2,disArray[0]);
        else
            return Math.max(maxDistance/2,Math.max(disArray[0],disArray[index-1]));
    }
}
