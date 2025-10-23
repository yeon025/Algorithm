import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new ArrayDeque<>();

        // 카드의 갯수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 큐에 1 ~ N까지 삽입
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            // 가장 최근에 들어온 숫자 빼기
            q.removeFirst();

            // 큐의 사이즈가 1이면 while문 탈출
            if (q.size() == 1) break;

            // 그 다음에 들어온 숫자를 맨 뒤로 이동
            int move = q.removeFirst();
            q.add(move);
        }

        // 마지막 남은 한장 출력
        System.out.println(q.peek());
    }
}