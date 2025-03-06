import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) x와 y의 좌표를 분리해서 각각 다른 배열에 저장
        Scanner scanner = new Scanner(System.in);

        String[] coordinate;
        int toIntX = 0;
        int toIntY = 0;
        List<Integer> xCoordinate = new ArrayList<>();
        List<Integer> yCoordinate = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            coordinate = scanner.nextLine().split(" ");
            toIntX = Integer.parseInt(coordinate[0]);
            toIntY = Integer.parseInt(coordinate[1]);
            xCoordinate.add(toIntX);
            yCoordinate.add(toIntY);
        }
        

        // 2) x좌표 배열에서 하나만 있는 값을 탐색
        int xFourth = 0;
        if (Objects.equals(xCoordinate.get(0), xCoordinate.get(1))) {
            xFourth = xCoordinate.get(2);
        } else if (Objects.equals(xCoordinate.get(0), xCoordinate.get(2))) {
            xFourth = xCoordinate.get(1);
        } else {
            xFourth = xCoordinate.get(0);
        }


        // 3) y좌표 배열에서 하나만 있는 값을 탐색
        int yFourth = 0;
        if (Objects.equals(yCoordinate.get(0), yCoordinate.get(1))) {
            yFourth = yCoordinate.get(2);
        } else if (Objects.equals(yCoordinate.get(0), yCoordinate.get(2))) {
            yFourth = yCoordinate.get(1);
        } else {
            yFourth = yCoordinate.get(0);
        }


        // 4) 결과 출력
        System.out.println(xFourth + " " + yFourth);
    }
}