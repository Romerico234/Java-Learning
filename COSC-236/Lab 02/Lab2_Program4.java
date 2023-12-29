import java.util.*;

public class Lab2_Program4 {
    public static void main(String[] args) {
        double testScore1;
        double testScore2;
        double testScore3;
        double avgTestScore;
        Scanner console = new Scanner(System.in);

        System.out.println("Enter three test scores:");
        testScore1 = console.nextDouble();
        testScore2 = console.nextDouble();
        testScore3 = console.nextDouble();

        avgTestScore = (testScore1 + testScore2 + testScore3) / 3.0;
        System.out.printf("Average score: %.2f%n", avgTestScore);
    }
}
