import java.io.*;
import java.util.*;


public class Main {

    public static int findNumberOfPrime(int N) {
        if (N == 1) {
            return 1;
        }

        int doubleN = 2 * N;

        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = N + 1; i <= doubleN; i++) {
            boolean isPrime = checkPrime(i);
            if (!isPrime) {
                primes.add(i);
            }
        }

        return primes.size();
    }

    public static boolean checkPrime(int number) {
        int root = (int) Math.sqrt(number) + 1;

        boolean isPrime = false;
        for (int i = 2; i <= root; i++) {
            if (number % i == 0) {
                isPrime = true;
                break;
            }
        }

        return isPrime;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 0을 입력 받을 때까지 계속 입력
        ArrayList<Integer> inputs = new ArrayList<>();

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) { break; }
            inputs.add(input);
        }

        // 입력 받은 숫자 N ~ 2N 까지의 소수 개수 구하기
        ArrayList<Integer> primeCount = new ArrayList<>();
        for (int N : inputs) {
            int count = findNumberOfPrime(N);
            primeCount.add(count);
        }

        // 출력
        for (int cnt : primeCount) {
            bw.write(cnt + "\n");
        }
        bw.flush();
    }
}