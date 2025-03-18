import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 좌표의 개수 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) N개의 좌표 입력
        int x = 0;
        int y = 0;
        int[][] xyArray = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] array = br.readLine().split(" ");
            x = Integer.parseInt(array[0]);
            y = Integer.parseInt(array[1]);
            xyArray[i][0] = x;
            xyArray[i][1] = y;
        }


        // 3) 오름차순 정렬
        Arrays.sort(xyArray, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        Arrays.sort(xyArray, (o1, o2) -> {
            return o1[0] - o2[0];
        });


        // 4) 출력
        for (int i = 0; i < N; i++) {
            System.out.println(xyArray[i][0] + " " + xyArray[i][1]);
        }
    }
}