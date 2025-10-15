import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer> stack = new ArrayList<>();
    static int size = 0;

    public static void runOne(String command) {
        String[] splited = command.split(" ");
        int input = Integer.parseInt(splited[1]);

        stack.add(input);
        size = stack.size();
    }

    public static void runTwo() {
        int removed = -1;
        if (!stack.isEmpty()) {
            removed = stack.remove(size - 1);
            size = stack.size();
        }
        System.out.println(removed);
    }

    public static void runThree() {
        System.out.println(size);
    }

    public static void runFour() {
        int isEmpty = 0;
        if (stack.isEmpty()) isEmpty = 1;
        System.out.println(isEmpty);
    }

    public static void runFive() {
        int last = -1;
        if (size != 0) {
            last = stack.get(size - 1);
        }
        System.out.println(last);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // N 개만큼 명령어 입력
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            commands.add(command);
        }

        // 입력받은 명령어 실행
        for (String command : commands) {
            if (command.contains(" ")) runOne(command);
            else if (command.equals("2")) runTwo();
            else if (command.equals("3")) runThree();
            else if (command.equals("4")) runFour();
            else runFive();
        }
    }
}