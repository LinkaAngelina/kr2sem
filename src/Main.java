import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину первого отрезка:");
        double a = scanner.nextDouble();

        System.out.println("Введите длину второго отрезка:");
        double b = scanner.nextDouble();

        System.out.println("Введите длину третьего отрезка:");
        double c = scanner.nextDouble();

        if (isTriangle(a, b, c)) {
            System.out.println("Из указанных отрезков можно составить треугольник.");
            double largestExternalAngle = findLargestExternalAngle(a, b, c);
            System.out.printf("Наибольший внешний угол треугольника: %.2f градусов%n", largestExternalAngle);
        } else {
            System.out.println("Из указанных отрезков нельзя составить треугольник.");
        }

        scanner.close();
    }

    private static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private static double findLargestExternalAngle(double a, double b, double c) {
        double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double angleC = Math.acos((a * a + b * b - c * c) / (2 * a * b));

        angleA = Math.toDegrees(angleA);
        angleB = Math.toDegrees(angleB);
        angleC = Math.toDegrees(angleC);

        double maxInternalAngle = Math.max(angleA, Math.max(angleB, angleC));

        return 180.0 - maxInternalAngle;
    }
}