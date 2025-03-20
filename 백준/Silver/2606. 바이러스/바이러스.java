import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        List<List<Integer>> graph = new ArrayList<>();

        // 1) 컴퓨터의 수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());


        // 2) 컴퓨터의 수만큼 ArrayList 생성
        for (int i = 0; i < computerCount + 1; i++) {
            graph.add(new ArrayList<>());
        }


        // 2) 간선(네트워크)의 수 입력
        int edgeCount = Integer.parseInt(br.readLine());


        // 3) 간선 입력, 그래프 생성
        for (int i = 0; i < edgeCount; i++) {
            String[] tmp = br.readLine().split(" ");
            int edge1 = Integer.parseInt(tmp[0]);
            int edge2 = Integer.parseInt(tmp[1]);

            graph.get(edge1).add(edge2);
            graph.get(edge2).add(edge1);
        }


        // 4) 그래프 오름차순 정렬
        for (int i = 0; i < computerCount + 1; i++) {
            Collections.sort(graph.get(i));
        }


        // 5) DFS 수행
        boolean[] DFS_visited = new boolean[computerCount + 1];
        Stack<Integer> stack = new Stack<>();
        int visitedNode = 0;

        stack.push(1);
        DFS_visited[1] = true;

        while (!stack.isEmpty()) {
            int popElement = stack.pop();
            // System.out.print(popElement + " ");
            visitedNode++;

            for (int node : graph.get(popElement)) {
                if (!DFS_visited[node]) {
                    stack.push(node);
                    DFS_visited[node] = true;
                }
            }
        }


        // 6) 방문한 노드(감염된 컴퓨터) 수 출력
        System.out.println(visitedNode - 1);
    }
}