import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int numNodes;
    static int[] indegree;
    static int[] outdegree;
    static int extraNode;

    static int[] checkGraphShape(int extraNode){
        int[] answer = new int[4];
        answer[0] = extraNode;

        ArrayList<Integer> baseNodes = adjList[extraNode];
        for(int innerNode : baseNodes){
            int countVertex = 0;
            int countEdge = 0;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(innerNode);
            countVertex++;
            visited[innerNode] = true;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int next: adjList[cur]){
                    if(!visited[next]){
                        visited[next] = true;
                        countEdge++;
                        countVertex++;
                        queue.add(next);
                    } else {
                        countEdge++;
                    }
                }
            }
            //System.out.println(countVertex + " " + countEdge);
            int n = 1;
            while (true) {
                if(n == countVertex && n == countEdge){
                    answer[1]++;
                    break;
                }
                if (n == countVertex && n - 1 == countEdge){
                    answer[2]++;
                    break;
                }
                if (2*n + 1 == countVertex && 2*n + 2 == countEdge){
                    answer[3]++;
                    break;
                }
                n++;
            }
        }
        
        return answer;
    }


    // 그래프를 순회하면서 그래프의 모양을 판별해라
    public static int[] solution(int[][] edges) {
        numNodes = 0;
        for(int i = 0; i < edges.length; i++) {
            for(int v : edges[i]) {
                numNodes = Math.max(numNodes, v);
            }
        }

        visited = new boolean[numNodes + 1];
        adjList = new ArrayList[numNodes + 1];

        for(int i = 0; i <= numNodes; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
        }

        indegree = new int[numNodes + 1];
        outdegree = new int[numNodes + 1];

        for (int i = 0; i <= numNodes; i++) {
            for(int v : adjList[i]) {
                outdegree[i]++;
                indegree[v]++;
            }
        }

        extraNode = -1;
        for(int i = 1; i <= numNodes; i++) {
            if(indegree[i] == 0 && outdegree[i] > 1) {
                extraNode = i;
                break;
            }
        }

        return checkGraphShape(extraNode);
    }
}