import java.io.*;
import java.security.Key;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 테스트케이스 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> listN = new ArrayList<>();
        ArrayList<Integer> listK = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            // N K 입력
            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[0]);
            
            // K가 N/2 보다 크다면 K는 N-K로 저장
            if (K > N/2) listK.add(N - K);
            else listK.add(K);
            
            // N 저장
            listN.add(N);
        }

        // 이항계수 계산
        for (int i = 0; i < T; i++) {
            
            // 분자 계산
            long combination = 1;
            int N = listN.get(i);
            for (int j = 1; j <= listK.get(i); j++) {
                combination = combination * N;
                N--;
            }

            // 분모 계산
            for (int j = 1; j <= listK.get(i); j++) {
                combination = combination / j;
            }
            bw.write(combination + "\n");
        }

        // 출력
        bw.flush();
    }
}