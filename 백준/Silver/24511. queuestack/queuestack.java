import java.io.*;
import java.util.*;


public class Main {

    static ArrayList<Integer> dataStructures = new ArrayList<>();
    static ArrayList<Integer> inDS = new ArrayList<>();
    static ArrayList<Integer> insertNumbers = new ArrayList<>();
    static Deque<Integer> deque = new ArrayDeque<>();
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 자료구조의 개수 N 입력
        Integer N = Integer.parseInt(br.readLine());

        // N개의 자료구조가 무엇인지 입력 (0이면 큐, 1이면 스택)
        String[] inputs = br.readLine().split(" ");
        for (String tmp : inputs) {
            int converted = Integer.parseInt(tmp);
            dataStructures.add(converted);
        }

        // 처음 자료구조에 들어갈 숫자 입력
        inputs = br.readLine().split(" ");
        for (String tmp : inputs) {
            int converted = Integer.parseInt(tmp);
            inDS.add(converted);
        }

        // 자료구조에 숫자 넣고 추가로 삽입할 숫자 길이 M 입력
        Integer M = Integer.parseInt(br.readLine());

        // 자료구조에 삽입할 숫자 입력
        String[] inputsM = br.readLine().split(" ");
        for (String tmp : inputsM) {
            int converted = Integer.parseInt(tmp);
            insertNumbers.add(converted);
        }


        // 큐일 때만 숫자 삽입
        for (int i = 0; i < N; i++) {
            if (dataStructures.get(i) == 0) {
                deque.addLast(inDS.get(i));
            }
        }

        // 데크에 M 길이의 수열 입력
        for (int i = 0; i < M; i++) {
            deque.addFirst(insertNumbers.get(i));
        }

        // 출력
        for (int i = 0; i < M; i++) {
            bw.write(deque.removeLast() + " ");
        }
        bw.flush();
    }
}