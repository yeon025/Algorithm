import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 상하의 개수 N 입력
        Integer N = Integer.parseInt(br.readLine());

        // N * (N - 1)
        System.out.println(N * (N - 1));
    }
}