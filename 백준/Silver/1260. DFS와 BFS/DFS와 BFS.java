import java.io.*;
import java.util.*;


public class Main {

    public static void DFS(List<List<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;

        System.out.print(start + " ");

        for (int edge : graph.get(start)) {
            if (!visited[edge]) {
                DFS(graph, edge, visited);
            }
        }
    }





    public static void main(String[] args) throws IOException {
        List<List<Integer>> graph = new ArrayList<>();


        // 1) 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V를 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);


        // 2) graph에 정점의 개수만큼 ArrayList를 추가
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        // 3) 간선을 입력
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int edge1 = Integer.parseInt(tmp[0]);
            int edge2 = Integer.parseInt(tmp[1]);

            graph.get(edge1).add(edge2);
            graph.get(edge2).add(edge1);
        }


        // 4) graph 내부 오름차순 정렬
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }


        // 그래프 출력
//        for (int i = 0; i < N + 1; i++) {
//            System.out.println("그래프 : " + (graph.get(i)));
//        }

        
        // 4) DFS 수행
        boolean[] DFS_visited = new boolean[N + 1];
        DFS(graph, V, DFS_visited);
        System.out.println();


        // 5) BFS 수행
        boolean[] BFS_visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        BFS_visited[V] = true;

        while(!queue.isEmpty()) {
            int queueOut = queue.poll();

            System.out.print(queueOut + " ");

            for(int edge : graph.get(queueOut)) {
                if (!BFS_visited[edge]) {
                    queue.offer(edge);
                    BFS_visited[edge] = true;
                }
            }
        }
    }
}