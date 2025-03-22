import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 검사의 기준이 되는 문자열의 개수 N과 검사할 문자열의 개수 N을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);


        // 2) N개의 문자열 입력
        List<String> conditionList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            conditionList.add(br.readLine());
        }


        // 3) M개의 문자열 입력
        List<String> testList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            testList.add(br.readLine());
        }


        // 4) 비교
        int count = 0;

        for (int i = 0; i < M; i++) {
            String compareString = testList.get(i);

            for (int j = 0; j < N; j++) {
                if (compareString.equals(conditionList.get(j))) {
                    count++;
                }
            }
        }

        
        // 5) 포함되어 있는 문자열의 개수
        System.out.println(count);
    }
}