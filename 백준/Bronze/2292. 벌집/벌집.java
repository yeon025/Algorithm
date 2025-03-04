import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1) 도착해야 할 방 번호를 입력
        Scanner scanner = new Scanner(System.in);
        int arriveRoom = scanner.nextInt();

        // 2) 지나가는 방의 개수를 계산
        int startLarger = 2;
        int endLarger = 1;
        int passByRoom = 1;
        int loopCount = 0;

        while (true) {
            if (arriveRoom == 1) { break; }

            passByRoom++;
            startLarger = startLarger + 6 * loopCount;
            endLarger = endLarger + 6 * (loopCount + 1);

            // System.out.println(startLarger + " <= " + arriveRoom + " <= " + endLarger);

            if ((startLarger <= arriveRoom) && (endLarger >= arriveRoom)) {
                break;
            }
            loopCount++;
        }

        // 3) 결과 출력
        System.out.println(passByRoom);
    }
}