import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        double A;
        double B;
        double result;

        A = sc.nextInt();
        B = sc.nextInt();

        result = A/B;
        System.out.println(result);
    }
}
