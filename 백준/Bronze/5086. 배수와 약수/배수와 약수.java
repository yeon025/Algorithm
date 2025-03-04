import java.util.*;



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stateList = new ArrayList<>();
        String state = "";

        while (true) {
            // 1) 두 개의 수 A, B를 입력받음
            String[] array = scanner.nextLine().split(" ");

            int A = Integer.parseInt(array[0]);
            int B = Integer.parseInt(array[1]);

            if (A == 0 && B == 0) {
                break;
            }

            // 2-1) A > B 라면 A가 B의 배수인지 확인
            // 2-2) A < B 라면 A가 B의 약수인지 확인
            if (A > B) {
                if (A % B == 0) {
                    state = "multiple";
                } else {
                    state = "neither";
                }
            } else {
                if (B % A == 0) {
                    state = "factor";
                } else {
                    state = "neither";
                }
            }
            stateList.add(state);
        }

        // 3) 약수라면 factor, 배수라면 multiple, 둘 다 아니라면 neither를 출력
        for (String s : stateList) {
            System.out.println(s);
        }
    }
}