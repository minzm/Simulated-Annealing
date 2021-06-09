import java.util.*;


public class SimulatedAnnealing {

    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println(" ax^3 + bx^2 + cx + d = 0의 최적해를 구하시오.");
        System.out.println(" a, b, c, d 를 차례대로 입력하세요.(단, a는 0이 아니다)");

        System.out.print("a = ");
        a = scan.nextDouble();
        System.out.print("b = ");
        b = scan.nextDouble();
        System.out.print("c = ");
        c = scan.nextDouble();
        System.out.print("d = ");
        d = scan.nextDouble();
        System.out.println("3차함수 : " + a + "x^3 + " + b + "x^2 + " + c + "x + " + d);

        double D = 4 * b * b - 12 * a * c;
        float z = 0;
        float y = (float) ((a * z * z * z) + (b * z * z) + (c * z) + d);

        if (D > 0) {
            if (a > 0) {
                z = (float) (((-2 * b) + Math.sqrt(D)) / (6 * a));
            } else if (a < 0) {
                z = (float) (((-2 * b) - Math.sqrt(D)) / (6 * a));
            }
            System.out.println("함수의 최적해 : " + z);
            System.out.println("최적해의 함숫값 : " + y);
        } else if (D == 0) {
            z = (float) ((-2 * b) / (6 * a));
            System.out.println("함수의 최적해 : " + z);
            System.out.println("최적해의 함숫값 : " + y);
        } else {
            System.out.println("값이 존재하지 않는다.");
        }
    }
}
