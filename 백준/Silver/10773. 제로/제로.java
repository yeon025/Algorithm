import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer> stack = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 T 입력
        int T = Integer.parseInt(br.readLine());

        // T개의 숫자 입력
        ArrayList<Integer> accountBook = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            accountBook.add(input);
        }

        // 0이면 스택 안에 숫자를 삭제하고 아니라면 삽입
        for (int money : accountBook) {
            if (money == 0) stack.remove(stack.size() - 1);
            else stack.add(money);
        }

        // 스택 안에 있는 숫자의 합계를 출력
        int total = 0;
        for (int element : stack) {
            total = total + element;
        }

        System.out.println(total);
    }
}