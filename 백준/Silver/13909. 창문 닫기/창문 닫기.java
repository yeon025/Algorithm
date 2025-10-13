import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 창문의 수와 사람의 수를 결정할 N 입력
        int N = Integer.parseInt(br.readLine());

        // 열려있는 창문의 개수 계산
        int count = (int) Math.sqrt(N);

        // 출력
        System.out.println(count);
    }
}