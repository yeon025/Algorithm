import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        int passByRoom = 0;


        // 1) N, M 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);



        // 3) 미로 입력
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                int toInt = row.charAt(j) - 48;
                maze[i][j] = toInt;
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(maze[i][j]);
//            }
//            System.out.println();
//        }


        // 4) 방문한 곳과 미로를 매핑
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }


        // 5) BFS
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pollElement = queue.poll();
            int x = pollElement[0];
            int y = pollElement[1];
            int dist = pollElement[2];

            if ((x == N - 1) && (y == M - 1)) {
                passByRoom = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if ((moveX > -1) && (moveX < N) && (moveY < M) && (moveY > -1) && (maze[moveX][moveY] == 1) && (!visited[moveX][moveY])) {
                    queue.offer(new int[]{moveX, moveY, dist + 1});
                    visited[moveX][moveY] = true;
                }
            }
        }



        // 6) 지나친 칸 수 출력
        System.out.println(passByRoom);

    }
}