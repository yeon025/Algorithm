import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        List<List<Integer>> graph = new ArrayList<>();


        // 1) 노드의 개수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());


        // 2) 노드의 개수만큼 ArrayList 생성
        for (int i = 0; i < nodeCount + 1; i++) {
            graph.add(new ArrayList<>());
        }


        // 3) 간선 입력
        for (int i = 0; i < nodeCount - 1; i++) {
            String[] tmp = br.readLine().split(" ");

            int edge1 = Integer.parseInt(tmp[0]);
            int edge2 = Integer.parseInt(tmp[1]);

            graph.get(edge1).add(edge2);
            graph.get(edge2).add(edge1);
        }


        // 4) 부모 노드를 저장할 배열 생성
        int[] parentNode = new int[nodeCount + 1];


        // 5) DFS 수행
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[nodeCount + 1];

        stack.push(1);
        visited[1] = true;

        while (!stack.isEmpty()) {
            int popElement = stack.pop();

            for (int node : graph.get(popElement)) {
                if (!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                    parentNode[node] = popElement;
                }
            }
        }


        // 6) 부모 노드 출력
        for (int i = 2; i < nodeCount + 1; i++) {
            System.out.println(parentNode[i]);
        }
    }
}