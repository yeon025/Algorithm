import java.io.*;
import java.util.*;


public class Main {
    static Deque<Integer> q = new ArrayDeque<>();


    public static void push(String command) {
        String splited = command.split(" ")[1];
        int number = Integer.parseInt(splited);
        q.add(number);
    }

    public static int pop() {
        int output = -1;
        if (!q.isEmpty()) output = q.poll();
        return output;
    }

    public static int isEmpty() {
        int output = 0;
        if (q.isEmpty()) output = 1;
        return output;
    }

    public static int front() {
        int output = -1;
        if (!q.isEmpty()) output = q.peek();
        return output;
    }

    public static int back() {
        int output = -1;
        if (!q.isEmpty()) output = q.peekLast();
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령어 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // N번 명령어 입력
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            commands.add(input);
        }

        // 명령어 실행
        ArrayList<Integer> outputs = new ArrayList<>();
        for (String command : commands) {
            if (command.contains("push")) {
                push(command);
            } else if (command.contains("pop")) {
                outputs.add(pop());
            } else if (command.contains("size")) {
                outputs.add(q.size());
            } else if (command.contains("empty")) {
                outputs.add(isEmpty());
            } else if (command.contains("front")) {
                outputs.add(front());
            } else {
                outputs.add(back());
            }
        }

        // 출력
        for (int output : outputs) {
            bw.write(output + "\n");
        }
        bw.flush();
    }
}