import java.io.*;
import java.util.*;


public class Main {
    static List<List<Integer>> graph;
    static Stack<Integer> stack;
    static boolean[] visited;
    static int[] parentNode;


    public static void DFS(int start) {
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int popElement = stack.pop();
            // System.out.print(popElement + " ");


            for (int node : graph.get(popElement)) {
                if (!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                    parentNode[node] = popElement;
                }
            }
        }
        // System.out.println();
    }



    public static void searchParentNode(List<Integer> targetList, int targetNode) {
        // System.out.print(targetNode + " : ");
        while (true) {
            if (parentNode[targetNode] == 0) {
                targetList.add(targetNode);
                // System.out.print(targetNode + " ");
                break;
            }

            targetList.add(targetNode);
            // System.out.print(targetNode + " ");
            targetNode = parentNode[targetNode];
        }
        // System.out.println();
    }



    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();


        // 1) 정점의 개수(사람 수) 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());


        // 2) 정점의 개수만큼 ArrayList 생성
        for (int i = 0; i < nodeCount + 1; i++) {
            graph.add(new ArrayList<>());
        }


        // 3) 계산해야 두 정점 입력
        String[] tmp = br.readLine().split(" ");
        int targetNode1 = Integer.parseInt(tmp[0]);
        int targetNode2 = Integer.parseInt(tmp[1]);


        // 4) 간선의 개수
        int edgeCount = Integer.parseInt(br.readLine());


        // 5) 간선 입력
        for (int i = 0; i < edgeCount; i++) {
            tmp = br.readLine().split(" ");
            int edge1 = Integer.parseInt(tmp[0]);
            int edge2 = Integer.parseInt(tmp[1]);

            graph.get(edge1).add(edge2);
            graph.get(edge2).add(edge1);
        }


        // 6) DFS 수행
        stack = new Stack<>();
        visited = new boolean[nodeCount + 1];
        parentNode = new int[nodeCount + 1];

        DFS(1);


        // 7) targetNode1과 targetNode2이 방문 여부가 다르다면 -1 출력
        if (visited[targetNode1] != visited[targetNode2]) {
            System.out.println(-1);
            return;
        }


        // 8) 방문하지 않은 노드가 있으면 DFS 수행
        int start = 0;
        int loop = 0;
        while (true) {

            // 8-1) 방문하지 않은 노드가 있는지 확인
            for (int i = 1; i < nodeCount + 1; i++) {
                if (!visited[i]) {
                    start = i;
                    break;
                }
                loop = i;
            }

            if (loop == nodeCount) {
                break;
            }

            // 8-2) 방문하지 않은 노드가 있으면 DFS 수행
            DFS(start);


            // 8-3) targetNode1과 targetNode2이 방문 여부가 다르다면 -1 출력
            if (visited[targetNode1] != visited[targetNode2]) {
                System.out.println(-1);
                return;
            }
        }



        // 9) 부모 노드 출력
//        System.out.print("[parentNode] : ");
//        for (int i = 1; i < nodeCount + 1; i++) {
//            System.out.print(parentNode[i] + " ");
//        }
//        System.out.println();



        // 10) 촌수 계산
        // 10-1) 타겟 노드의 부모 노드를 조사
        List<Integer> targetList1 = new ArrayList<>();
        searchParentNode(targetList1, targetNode1);

        List<Integer> targetList2 = new ArrayList<>();
        searchParentNode(targetList2, targetNode2);


        // 10-2) 포함 관계인지 확인
        for (int i = 0; i < targetList1.size(); i++) {
            if (targetList1.get(i) == targetNode2) {
                System.out.println(i);
                return;
            }
        }

        for (int i = 0; i < targetList2.size(); i++) {
            if (targetList2.get(i) == targetNode1) {
                System.out.println(i);
                return;
            }
        }


        // 10-3) 포함 관계가 아닐 때 거리 계산
        int result = (targetList1.size() - 1) + (targetList2.size() - 1);
        System.out.println(result);
    }
}