import java.io.*;
import java.util.*;


public class Main {
    static Deque<Integer> deque = new LinkedList<>();


    public static int runThree() {
        int removed = -1;
        if (!deque.isEmpty()) removed = deque.removeFirst();
        return removed;
    }

    public static int runFour() {
        int removed = -1;
        if (!deque.isEmpty()) removed = deque.removeLast();
        return removed;
    }

    public static int runFive() {
        return deque.size();
    }

    public static int runSix() {
        int isEmpty = 0;
        if (deque.isEmpty()) isEmpty = 1;
        return isEmpty;
    }

    public static int runSeven() {
        int firstNumber = -1;
        if (!deque.isEmpty()) firstNumber = deque.getFirst();
        return firstNumber;
    }

    public static int runEight() {
        int lastNumber = -1;
        if (!deque.isEmpty()) lastNumber = deque.getLast();
        return lastNumber;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령의 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // N번 입력
        ArrayList<String> commands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            commands.add(command);
        }

        // 명령어 수행
        ArrayList<Integer> results = new ArrayList<>();

        for (String command : commands) {
            if (command.contains("1") || command.contains("2")) {
                String[] splited = command.split(" ");
                int first = Integer.parseInt(splited[0]);
                int second = Integer.parseInt(splited[1]);

                if (first == 1) deque.addFirst(second);
                else deque.addLast(second);
            }

            if (command.equals("3")) results.add(runThree());
            else if (command.equals("4")) results.add(runFour());
            else if (command.equals("5")) results.add(runFive());
            else if (command.equals("6")) results.add(runSix());
            else if (command.equals("7")) results.add(runSeven());
            else if (command.equals("8")) results.add(runEight());
        }

        // 출력
        for (Integer result : results) {
            bw.write(result + "\n");
        }
        bw.flush();
    }
}