import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 입력할 좌표의 개수 N을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) N개의 x좌표 입력
        int[] xArray = new int[N];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            xArray[i] = Integer.parseInt(tmp[i]);
        }


        // 3) Set으로 중복값 제거
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(xArray[i]);
        }
        // System.out.println("set : " + set);


        // 4) Set을 배열로 변환
        Integer[] ascending = set.toArray(new Integer[0]);


        // 5) 오름차순 정렬
        Arrays.sort(ascending);


        // 6) 좌표 배열과 오름차순 배열을 이진탐색
        int len = ascending.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;


        for (int i = 0; i < N; i++) {
            mid = len / 2;
            low = 0;
            high = len - 1;

            while (true) {
                if (xArray[i] == ascending[mid]) {
                    xArray[i] = mid;
                    break;
                } else if (xArray[i] > ascending[mid]) {
                    low = mid + 1;
                    mid = (high + low) / 2;
                } else {
                    high = mid - 1;
                    mid = (high + low) / 2;
                }
            }
        }


        // 7) 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(xArray[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}