import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // 1) 회원 수 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) N명의 회원 나이와 이름 입력
        String[][] memberInfo = new String[N][2];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            memberInfo[i][0] = tmp[0];
            memberInfo[i][1] = tmp[1];
        }


        // 3) 나이 순으로 오름차순 정렬
        Arrays.sort(memberInfo, (o1, o2) -> {
            return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
        });


        // 4) 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(memberInfo[i][0]) + " " + String.valueOf(memberInfo[i][1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}