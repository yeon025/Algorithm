import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        // 승환이 앞에 서 있는 학생 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 앞 사람들의 번호 입력
        String[] people = br.readLine().split(" ");
        int [] personInFront = new int[N];

        for (int i = 0; i < N; i++) {
            personInFront[i] = Integer.parseInt(people[i]);
        }

        // personInFront 배열의 수를 스택에 넣거나 뺌
        int numberTicket = 1;
        int i = 0;

        while (i < N) {

            if (!stack.isEmpty() && numberTicket == stack.peek()){
                stack.pop();
                numberTicket++;
                continue;
            }

            if (personInFront[i] == numberTicket) numberTicket++;
            else stack.push(personInFront[i]);
            i++;
        }

        // 스택에 남아있는 숫자를 빼기
        while (!stack.isEmpty() && numberTicket <= N) {
            if (stack.peek() == numberTicket) stack.pop();
            numberTicket++;
        }

        // 스택이 비어있는지 확인
        if (stack.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }
}