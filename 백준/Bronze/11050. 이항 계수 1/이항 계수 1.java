import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N K 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        // 이항계수 계산
        int result = 1;
        for (int i = 1; i <= K; i++) {
            result = result * N;
            N--;
        }
        for (int j = 1; j <= K; j++) {
            result = result / j;
        }

        // 출력
        System.out.println(result);
    }
}