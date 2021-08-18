package com.jerryr.prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);

        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);

    }

}

//创建最小生成树->村庄的图
class MinTree{
    /**
     * @description: 创建图的邻接矩阵
     * @param graph 图对象
	 * @param verxs 图对应的顶点个数
	 * @param data 图的各个顶点的值
	 * @param weight 图的邻接矩阵
     * @return void
     * @author: jerryr
     * @dateTime: 2021/8/16 16:57
     */
    public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph( MGraph graph){
        for (int[] links : graph.weight) {
            System.out.println(Arrays.toString(links));
        }
    }

    public void prim(MGraph mGraph,int v){
        boolean[] visited = new boolean[mGraph.verxs];
        visited[v] = true;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < mGraph.verxs; k++) {
            for (int i = 0; i < mGraph.verxs; i++) {
                for (int j = 0; j < mGraph.verxs; j++) {
                    if (visited[i] == true && visited[j] == false && mGraph.weight[i][j] < minWeight){
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + mGraph.data[h1] + "," + mGraph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = true;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }

    }
}

class MGraph{
    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
