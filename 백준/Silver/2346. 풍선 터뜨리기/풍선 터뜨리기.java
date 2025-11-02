import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> deque = new ArrayDeque<>();

        // 풍선의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 풍선에 들어갈 숫자 입력
        String[] inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            String converted = i + " " + inputs[i - 1];
            deque.addLast(converted);
        }

        ArrayList<Integer> results = new ArrayList<>();

        // 1번 풍선 터뜨리기
        String removed = deque.removeFirst();
        // 터진 풍선 번호 저장
        String[] splited = removed.split(" ");
        results.add(Integer.valueOf(splited[0]));

        while (!deque.isEmpty()) {
            int distance = Integer.parseInt(splited[1]);
            if (distance > 0) {
                // 풍선을 터뜨리고 나온 숫자만큼 이동
                for (int i = 1; i < distance; i++) {
                    deque.addLast(deque.removeFirst());
                }
                // 풍선 터뜨리기
                removed = deque.removeFirst();
            } else {
                for (int i = 1; i < Math.abs(distance); i++) {
                    deque.addFirst(deque.removeLast());
                }
                removed = deque.removeLast();
            }
            splited = removed.split(" ");
            results.add(Integer.valueOf(splited[0]));
        }

        // 출력
        for (int i = 0; i < N; i++) {
            if (i == N - 1) bw.write(results.get(i) + "\n");
            else bw.write(results.get(i) + " ");
        }
        bw.flush();
    }
}