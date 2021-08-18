package com.jerry.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public static void main(String[] args) {
        int n = 5;
        String Vertex[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String vertex : Vertex) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();

    }

    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边 的数目
    private boolean[] isVisited;//记录某个结点是否被访问
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回下标对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;

    }
    //得到第一个邻接结点的下标w
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0)
                return i;
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2 + 1; i < vertexList.size() ; i++) {
            if (edges[v1][i] > 0)
                return i;

        }
        return -1;
    }
    //深度优先遍历
    private void dfs(boolean[] isVisited,int i){
        System.out.println(getValueByIndex(i) + "-->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while ( w != -1){
            if (!isVisited[w])
                dfs(isVisited,w);
            w = getNextNeighbor(i,w);
        }
    }
    //dfs重载
    public void dfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //广度优先遍历
    private void bfs(boolean[] isVisited,int i){
        int u,w;
        LinkedList queue = new LinkedList();
        System.out.println(getValueByIndex(i)+"-->");
        isVisited[i] = true;
        queue.addLast(i);//结点入队列，入队列的所有结点都将分别进行广度优先遍历
        while (!queue.isEmpty()){
            u = ((Integer) queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w) + "-->");
                    isVisited[w] = true;
                    queue.addLast(w);//入队列。对这个结点进行邻接点访问
                }
                w = getNextNeighbor(u,w);//寻找下一个邻接点
            }
        }
    }
    //bfs重载
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

}
