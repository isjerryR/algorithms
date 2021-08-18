package com.jerryr.dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
    }

}

// 已访问顶点集合
class VisitedVertex{
    // 记录各个顶点是否访问过 1表示访问过,0未访问,会动态更新
    public int[] alreadyArray;
    // 每个下标对应的值为前一个顶点下标, 会动态更新
    public int[] preVisited;
    // 记录出发顶点到其他所有顶点的距离,比如G为出发顶点，就会记录G到其它顶点的距离，会动态更新，求的最短距离就会存放到dis
    public int[] dis;
    /**
     * @description: TODO
     * @param length 表示顶点的个数
	 * @param index 除法定点对应的下标，比如G顶点，下标就是6
     * @return 
     * @author: jerryr
     * @dateTime: 2021/8/16 21:56
     */
    public VisitedVertex(int length,int index) {
        this.alreadyArray = new int[length];
        this.preVisited = new int[length];
        this.dis = new int[length];
        //初始化 dis数组
        Arrays.fill(dis, 65535);
        this.alreadyArray[index] = 1; //设置出发顶点被访问过
        this.dis[index] = 0;//设置出发顶点的访问距离为0
    }
    /**
     * @description: 判断index顶点是否被访问过
     * @param index 
     * @return boolean 如果访问过就返回true，否则返回false
     * @author: jerryr
     * @dateTime: 2021/8/16 21:59
     */
    public boolean in(int index){
        return alreadyArray[index] == 1;
    }

    /**
     * @description: 更新出发顶点到index顶点的距离
     * @param index
	 * @param len
     * @return void
     * @author: jerryr
     * @dateTime: 2021/8/16 22:01
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }
    /**
     * 功能: 更新pre这个顶点的前驱顶点为index顶点
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        preVisited[pre] = index;
    }
    /**
     * 功能:返回出发顶点到index顶点的距离
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }
    
}

class Graph{
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph(){
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }
    
    public void dsj(int index){
        VisitedVertex visitedVertex = new VisitedVertex(vertex.length, index);
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点,
    private void update(int index) {
        int len = 0;
        //根据遍历我们的邻接矩阵的  matrix[index]行
        for (int i = 0; i < matrix[index].length; i++) {

        }
    }
}