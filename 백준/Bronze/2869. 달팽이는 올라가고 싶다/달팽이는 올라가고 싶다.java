import java.util.*;



public class Main {

    public static void main(String[] args) {
        // 1) 낮에 올라간 높이, 밤에 미끄러진 높이, 올라갈 높이를 입력
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");

        int climb = Integer.parseInt(inputArray[0]);
        int slip = Integer.parseInt(inputArray[1]);
        int height = Integer.parseInt(inputArray[2]);


        // 2) 올라가기 까지 걸린 날짜를 저장하는 변수 생성
        int day = 0;


        // 3-1) 끝까지 다 올라가면 떨어지지 않기 때문에 전체 높이에서 낮에 올라간 높이를 뺌
        // 3-2) 3-1의 결과 / (올라갈 높이 - 떨어질 높이)
        // 3-3) 나머지 높이도 올라가야 하기 때문에 "3-1의 결과 % (올라갈 높이 - 떨어질 높이)"도 하루를 소모
        day = (height - climb) / (climb - slip);
        int remain = (height - climb) % (climb - slip);
        
        // System.out.println("day : " + day);
        // System.out.println("remain : " + remain);

        if (remain != 0) {
            day++;
        }
        day++;


        // 4) 결과 출력
        System.out.println(day);
    }
}