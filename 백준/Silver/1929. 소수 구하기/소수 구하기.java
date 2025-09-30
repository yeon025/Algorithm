import java.io.*;
import java.util.*;


public class Main {

    public static ArrayList<Integer> findPrimes(int M, int N) {
        ArrayList<Integer> primes = new ArrayList<>();

        if (M < 2) { M = 2; }

        for(int i = M; i <= N; i++) {
            boolean isPrime = findPrime(i);
            if (!isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static boolean findPrime(int number) {
        int root = (int) Math.sqrt(number) + 1;

        boolean isPrime = false;
        for (int i = 2; i < root; i++) {
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

        // 자연수 M N을 입력
        String[] arr = br.readLine().split(" ");
        int M = Integer.parseInt(arr[0]);
        int N = Integer.parseInt(arr[1]);

        // M ~ N 까지의 소수 찾기
        ArrayList<Integer> primeList = findPrimes(M, N);

        // 출력
        for (Integer prime : primeList) {
            bw.write(prime + "\n");
        }
        bw.flush();
    }
}