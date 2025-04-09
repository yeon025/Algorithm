import java.io.*;
import java.util.*;


public class Main {
    public static int gcdRec(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcdRec(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        // 테스트 케이스 개수 T 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        // T개의 테스트 케이스 입력
        int[] a = new int[T];
        int[] b = new int[T];

        for (int i = 0; i < T; i++) {
            String[] tmp = br.readLine().split(" ");

            a[i] = Integer.parseInt(tmp[0]);
            b[i] = Integer.parseInt(tmp[1]);
        }



        for (int i = 0; i < T; i++) {
            // 최대공약수 구하기
            int gcd = gcdRec(a[i], b[i]);


            // 최소공배수 구하기
            int result = a[i] * b[i] / gcd;


            // 출력
            System.out.println(result);
        }

    }
}