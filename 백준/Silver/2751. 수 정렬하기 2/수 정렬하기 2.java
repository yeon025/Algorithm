import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 입력할 숫자의 개수 N을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) N개의 정렬할 숫자 입력
        int tmp = 0;
        int[] numberList = new int[N];
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            numberList[i] = tmp;
        }


        // 3) 오름차순 정렬
        Arrays.sort(numberList);


        // 4) 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(numberList[i]);
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}