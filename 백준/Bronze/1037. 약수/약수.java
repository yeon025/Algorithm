import java.io.*;
import java.security.Key;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 약수의 개수 N 입력
        Integer N = Integer.parseInt(br.readLine());

        // 약수 입력
        String[] inputs = br.readLine().split(" ");
        ArrayList<Integer> factors = new ArrayList<>();
        for (String input : inputs) {
            factors.add(Integer.parseInt(input));
        }

        // 입력한 약수 중에 가장 작은 수를 찾음
        int min = factors.get(0);
        for (int i = 1; i < N; i++) {
            if (min > factors.get(i)) min = factors.get(i);
        }

        // 입력한 약수 중에 가장 큰 수를 찾음
        int max = factors.get(0);
        for (int i = 1; i < N; i++) {
            if (max < factors.get(i)) max = factors.get(i);
        }

        // 가장 작은 수와 큰 수를 곱함
        bw.write(min * max + "\n");

        // 출력
        bw.flush();
    }
}