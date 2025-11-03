import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 녹색거탑의 높이 N 입력
        Integer N = Integer.parseInt(br.readLine());

        // 2^N
        System.out.println((int)Math.pow(2, N));
    }
}