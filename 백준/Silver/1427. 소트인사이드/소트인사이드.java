import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 정렬할 숫자 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();


        // 2) 숫자를 배열로 변환
        Integer[] array = new Integer[N.length()];
        int i = 0;

        while (true) {
            array[i] = N.charAt(i) - 48;
            i++;

            if (i == N.length()) {
                break;
            }
        }


        // 3) 내림차순 정렬
        Arrays.sort(array, Collections.reverseOrder());


        // 4) 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int j = 0; j < N.length(); j++) {
            bw.write(String.valueOf(array[j]));
        }
        bw.flush();
        bw.close();
    }
}