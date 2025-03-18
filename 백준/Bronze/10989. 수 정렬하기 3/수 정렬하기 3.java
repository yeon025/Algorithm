import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 입력할 숫자의 개수 N을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) N개의 정렬할 숫자 입력
        int tmp = 0;
        int[] numberArray = new int[N];
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            numberArray[i] = tmp;
        }


        // 3) numberArray에서 최대값 찾기
        int largestNumber = 0;

        for (int number : numberArray) {
            largestNumber = Math.max(largestNumber, number);
        }


        // 3) 오름차순 정렬
        int[] countingArray = new int[largestNumber + 1];
        for (int i = 0; i < N; i++) {
            countingArray[numberArray[i]]++;
        }


        // 4) 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < largestNumber + 1; i++) {

            while (countingArray[i]-- > 0) {
                bw.write(i + "\n");
            }
            bw.flush();
        }

        bw.close();
    }
}