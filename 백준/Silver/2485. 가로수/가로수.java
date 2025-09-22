import java.io.*;
import java.util.*;


public class Main {
    public static int findGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return findGcd(num2, num1 % num2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력할 숫자의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // N번 입력
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        // 가로수의 간격 구하기
        ArrayList<Integer> distanceArr = new ArrayList<>();
        for (int i = N - 1; i > 0; i--) {
            int distance = arr.get(i) - arr.get(i - 1);
            distanceArr.add(distance);
        }

        // 가로수의 간격으로 최대공약수 구하기
        int gcd = distanceArr.get(0);
        for (int i = 1; i < distanceArr.size(); i++) {
            gcd = findGcd(gcd, distanceArr.get(i));
        }

        // 처음 입력한 숫자부터 최대공약수만큼 커지는 배열 크기 구하기
        int gcdArrSize = (arr.get(N - 1) - arr.get(0)) / gcd;
        gcdArrSize = gcdArrSize + 1;

        System.out.println(gcdArrSize - arr.size());
    }
}