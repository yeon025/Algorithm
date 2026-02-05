import java.io.*;
import java.util.*;




public class Main {

    public static long fibonacci(int N) {
        if (N == 0) return 0;
        if (N <= 2) return 1;

        return fibonacci(N - 1) + fibonacci(N - 2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N의 피보나치 계산
        long result = fibonacci(N);

        // 출력
        bw.write(result + "\n");
        bw.flush();
    }
}