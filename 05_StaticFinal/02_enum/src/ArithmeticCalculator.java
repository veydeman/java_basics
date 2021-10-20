public class ArithmeticCalculator {

    public static double a;
    public static double b;

    public ArithmeticCalculator(double a, double b) {
        ArithmeticCalculator.a = a;
        ArithmeticCalculator.b = b;
    }

    public double calculate(Operation operation) {
        if (operation == Operation.ADD) {
            return a + b;
        } else if (operation == Operation.MULTIPLY) {
            return a * b;
        } else {
            return a - b;
        }
    }
}
