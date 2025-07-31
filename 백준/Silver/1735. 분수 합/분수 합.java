import java.io.*;
import java.util.*;


public class Main {


    // 약수 찾기
    public static void findDivisor(ArrayList<Integer> divisorArr, int denominator) {

        for (int divisor = 1; divisor <= denominator; divisor++) {
            if (denominator % divisor == 0) {
                divisorArr.add(divisor);
            }
        }
    }


    // 최대공약수 찾기
    public static int findGCD(int denominator1, int denominator2) {
        ArrayList<Integer> divisorArr = new ArrayList<>();
        findDivisor(divisorArr, denominator1);
        findDivisor(divisorArr, denominator2);

        Set<Integer> duplicate = new HashSet<>();

        return divisorArr.stream()
                .filter(v -> !duplicate.add(v))
                .max(Integer::compareTo)
                .orElse(0);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 분자, 분모 입력
        int[] fraction = new int[4];

        for (int i = 0; i < 4; i = i + 2) {
            String[] tmp = br.readLine().split(" ");
            fraction[i] = Integer.parseInt(tmp[0]);
            fraction[i + 1] = Integer.parseInt(tmp[1]);
        }


        // 최소공배수를 찾기 위해 최대공약수 찾기
        int gcd = findGCD(fraction[1], fraction[3]);


        // 최소공배수(분모) 찾기
        int lcm = gcd * (fraction[1] / gcd) * (fraction[3] / gcd);


        // 분자 구하기
        int numerator = fraction[0] * (lcm / fraction[1]) + fraction[2] * (lcm / fraction[3]);


        // 약분
        int reduceFactor = findGCD(numerator, lcm);
        int reducedNumerator = numerator / reduceFactor;
        int reducedDenominator = lcm / reduceFactor;


        // 출력
        System.out.println(reducedNumerator + " " + reducedDenominator);
    }
}