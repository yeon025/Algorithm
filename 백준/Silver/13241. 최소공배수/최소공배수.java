import java.io.*;
import java.util.*;


public class Main {

    public static long gcdRec(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcdRec(b, a % b);
    }

    public static void main(String[] args) throws IOException {

        // a, b 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        long a = Integer.parseInt(tmp[0]);
        long b = Integer.parseInt(tmp[1]);

        // 최대공약수 구하기
        long gcd = gcdRec(a, b);

        // 최소공배수 구하기
        long result = a * b / gcd;

        // 출력
        System.out.println(result);
    }
}