import java.io.*;
import java.util.*;


public class Main {

    public static void DFS(List<List<Integer>> graph, int start, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        int popElement = 0;

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            popElement = stack.pop();
            // System.out.print(popElement + " ");

            for (int node : graph.get(popElement)) {
                if (!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> graph = new ArrayList<>();
        int connectingCount = 0;

        // 1) 정점의 개수 N, 간선의 개수 M을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);


        // 2) 정점의 개수만큼 ArrayList 생성
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        // 3) M개의 간선 입력
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int edge1 = Integer.parseInt(tmp[0]);
            int edge2 = Integer.parseInt(tmp[1]);

            graph.get(edge1).add(edge2);
            graph.get(edge2).add(edge1);
        }


        // 4) DFS 수행하고 연결요소 개수 구하기
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];

        DFS(graph, 1, visited);
        connectingCount++;


        // 5) 모든 노드를 방문할 때 까지 DFS 실행
        int start = 0;
        int loopCount = 0;
        while (true) {
            loopCount = 0;
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    start = i;
                    break;
                }
                loopCount++;
            }

            if (loopCount == N) {
                break;
            }

            DFS(graph, start, visited);
            // System.out.println();
            connectingCount++;
        }

        // 6) 연결 요소 개수 출력
        System.out.println(connectingCount);
    }
}