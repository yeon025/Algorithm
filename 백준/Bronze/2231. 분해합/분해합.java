import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) 자연수 N을 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();


        // 2) 1부터 브루트포싱으로 N의 분해합을 구함
        int sum = 0;
        String toString;
        List<Integer> digitList = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            toString = Integer.toString(i);
            String[] toStringArray = toString.split("");

            for (String digit : toStringArray) {
                digitList.add(Integer.parseInt(digit));
            }
            // System.out.println("digitList : " + digitList);

            sum = i;
            for(int digit : digitList) {
                sum = sum + digit;
            }

            if (sum == N) {
                System.out.println(i);
                return;
            }

            digitList = new ArrayList<>();
        }
        System.out.println(0);
    }
}