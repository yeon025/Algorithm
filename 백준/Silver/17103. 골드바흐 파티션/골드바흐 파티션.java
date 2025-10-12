import java.io.*;
import java.util.*;


public class Main {


    public static int[] createBoolean() {
        int[] zeroOne = new int[1000001];

        // 2 ~ 1000000 까지 소수가 있는지 확인
        for (int i = 2; i <= 1000000; i++) {
            int root = (int) Math.sqrt(i) + 1;
            boolean isPrime = true;

            // 소수인지 체크
            for (int j = 2; j < root; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // 소수라면 배열에 추가
            if (isPrime) zeroOne[i] = 1;
        }
        return zeroOne;
    }

    public static int findGoldBah(int value, int[] zeroOne) {

        // 입력한 수보다 작은 소수 구하기
        ArrayList<Integer> primes = findPrimes(value, zeroOne);

        int count = 0;

        // 골드바흐 파티션 계산
        for (int i = 0; i < primes.size(); i++) {
            // value/2 보다 크면 break
            if (primes.get(i) > value / 2) break;

            int sub = value - primes.get(i);

            // sub가 소수라면 if 문을 통과
            if (zeroOne[sub] == 1) count++;
        }
        return count;
    }

    public static ArrayList<Integer> findPrimes(int value, int[] zeroOne) {
        ArrayList<Integer> primes = new ArrayList<>();

        // 2 ~ value 까지 소수가 있는지 확인
        for (int i = 2; i <= value; i++) {
            // 소수인지 체크
            if (zeroOne[i] == 1) primes.add(i);
        }
        return primes;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 T 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 개수만큼 입력
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr.add(tmp);
        }

        // 1 ~ 1,000,000이 소수인지 확인
        int[] zeroOne = createBoolean();

        // 입력한 숫자보다 작은 소수를 구하고 골드바흐 파티션 계산
        ArrayList<Integer> result = new ArrayList<>();
        for (int tmp : arr) {
            int goldBahCount = findGoldBah(tmp, zeroOne);
            result.add(goldBahCount);
        }

        // 출력
        for (int tmp : result) {
            bw.write(tmp + "\n");
        }
        bw.flush();
    }
}