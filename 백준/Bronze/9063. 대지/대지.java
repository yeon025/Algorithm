import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 입력할 개수 N를 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();


        // 2) N개의 좌표를 입력하고 x, y 따로 배열에 저장
        String[] coordinateArray;
        int toIntX;
        int toIntY;
        List<Integer> xCoordinateList = new ArrayList<>();
        List<Integer> yCoordinateList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coordinateArray = scanner.nextLine().split(" ");
            toIntX = Integer.parseInt(coordinateArray[0]);
            toIntY = Integer.parseInt(coordinateArray[1]);
            xCoordinateList.add(toIntX);
            yCoordinateList.add(toIntY);
        }


        // 3) N이 1일 때 0을 출력
        if (N == 1) {
            System.out.println(0);
            return;
        }


        // 4) x 좌표 배열에서 가장 작은 수와 가장 큰 수를 뺌
        int xRectangle = 0;
        int xLargest =  xCoordinateList.get(0);
        int xShortest =  xCoordinateList.get(0);
        for (int i = 1; i < N; i++) {
            if (xLargest < xCoordinateList.get(i)) {
                xLargest = xCoordinateList.get(i);
            }
            if (xShortest > xCoordinateList.get(i)) {
                xShortest = xCoordinateList.get(i);
            }
        }
        xRectangle = xLargest - xShortest;


        // 5) y 좌표 배열에서 가장 작은 수와 가장 큰 수를 뺌
        int yRectangle = 0;
        int yLargest =  yCoordinateList.get(0);
        int yShortest =  yCoordinateList.get(0);
        for (int i = 1; i < N; i++) {
            if (yLargest < yCoordinateList.get(i)) {
                yLargest = yCoordinateList.get(i);
            }
            if (yShortest > yCoordinateList.get(i)) {
                yShortest = yCoordinateList.get(i);
            }
        }
        yRectangle = yLargest - yShortest;


        // 6) 4, 5의 결과를 곱함
        System.out.println(xRectangle * yRectangle);
    }
}