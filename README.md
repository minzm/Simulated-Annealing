# Simulated-Annealing
    담금질 기법(Simulated Annealing)은 전역 최적화 문제에 대한 일반적인 확률적 메타 알고리즘이다.
    
    
3차 함수 최적해 구하기
--------------------------


  1. 함수의 최적해란?
  
    - 함수의 최적해란 함수 값이 인근 점에서보다는 더 작지만 멀리 있는 점에서보다는 더 클 수 있는 점을 말한다.
    
  2. 어떻게 구현 할 것인가?
    
    - 3차 함수에서는 최적해가 극솟값이기 때문에 3차 함수를 설정한 후 그것의 극솟값을 구한다.
    
  3. 코드
  ```java 
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
```
  4. 설명
  
    (1) 3차함수 설정하기
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
        
        -위와 같이 직접 입력해서 3차함수를 설정할 수 있도록 코딩
        
    (2) 미분활용
        double D = 4 * b * b - 12 * a * c;                               // 3차 함수를 미분한 2차 함수의 판별식 D
        float z = 0;                                                     // 최적해 z 변수 선언
        float y = (float) ((a * z * z * z) + (b * z * z) + (c * z) + d); // 3차 함수의 y값
        
        -미분한 2차 방정식의 판별식을 만들고 3차 함수의 극솟값인 최적해와 그 함숫값을 z,y 로 설정함
        
    (3) 3차 함수 모양에 따른 최적해 구하기
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
    
        -3차 함수(ax^3 + bx^2 + cx +d = 0)를 미분하면 2차 방정식 (6ax^2 + 2bx + c = 0)이 나온다.
         이 2차 방정식을 0으로 만드는 값이 3차 함수의 극솟값, 극댓값을 결정한다.
         먼저 판별식 D가 0보다 크다면 위와 같이 극솟값의 X 값은 계수 a가 양수인지 음수인지에 따라 결정된다.
         판별식 D가 0이라면 x값은 -2b/6a 이다.
         하지만 D가 0보다 작다면 허수가 나오기 때문에 존재하지 않는다.
         * Math.sqrt() : 제곱근을 구하는 자바 문법 
         
  5. 실행화면
  
   ![image](https://user-images.githubusercontent.com/80373177/121355559-f3447b80-c96a-11eb-9165-9da23b2fae77.png)
   
  6. 증명
  
   ![image](https://user-images.githubusercontent.com/80373177/121355961-61893e00-c96b-11eb-8f6c-3563afda50f5.png)
   
   
   
   이로써 올바르게 작동하는 것을 확인 할 수 있다. 4차 함수도 마찬가지로 4차 함수를 미분한 3차 방정식의 근의 공식을 이용하여 최적해를 구할 수 있다.


  
  
    
    
    


    
