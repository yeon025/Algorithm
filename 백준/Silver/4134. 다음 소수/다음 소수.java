import java.io.*;
import java.util.*;


public class Main {

    public static Long findPrimeGreaterEqual(Long number) {
        boolean isPrime = false;

        for (int i = 2; i <= Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                isPrime = true;
                break;
            }
        }

        if (isPrime) {
            return findPrimeGreaterEqual(++number);
        }
        return number;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 N 입력
        int N = Integer.parseInt(br.readLine());

        // N번 입력
        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Long input = Long.parseLong(br.readLine());
            arr.add(input);
        }

        // 입력한 숫자보다 크거나 같은 소수 찾기
        ArrayList<Long> decimalList = new ArrayList<>();
        for (Long tmp : arr) {
            Long prime = (tmp < 3) ? 2L : findPrimeGreaterEqual(tmp);
            decimalList.add(prime);
        }

        // 소수 출력
        for (Long result : decimalList) {
            bw.write(result + "\n");
        }
        bw.flush();
    }
}