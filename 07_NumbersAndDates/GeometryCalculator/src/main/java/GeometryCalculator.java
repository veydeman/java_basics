public class GeometryCalculator {

    private static double radius = 0.0;
    private static double a;
    private static double b;
    private static double c;
    private static double semiperimeter;

    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (double) 4 / (double) 3 * Math.PI * Math.pow(Math.abs(radius), 3);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if ((a + b > c) & (a + c > b) & (b + c > a)) {
            return true;
        } else {
            return false;
        }
    }
    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0

    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c)) {
            semiperimeter = (a + b + c) / 2;
            return Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
        }
        return -1.0;
    }
}