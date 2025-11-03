import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N!
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result = result * i;
        }

        // 출력
        System.out.println(result);
    }
}