import java.io.*;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        // N명의 사람과 제거할 순서 K 입력
        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);

        // 큐에 1 ~ N까지 삽입
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        // 큐에 제거할 요소가 없을 때까지 K번 단위로 삭제
        ArrayList<Integer> results = new ArrayList<>();
        while (!q.isEmpty()) {
            // 삭제
            for (int i = 1; i < K; i++) {
                q.add(q.poll());
            }
            int removed = q.poll();

            // 삭제된 순서대로 배열에 삽입
            results.add(removed);
        }

        // 출력
        bw.write("<");
        for (int i = 0; i < N; i++) {
            if (i != N - 1) bw.write(results.get(i) + ", ");
            else bw.write(results.get(i) + ">");
        }
        bw.flush();
    }
}