public class ArithmeticCalculator {

    public static double a;
    public static double b;

    public Operation operation;

    public ArithmeticCalculator (double a, double b, Operation operation) {
        ArithmeticCalculator.a = a;
        ArithmeticCalculator.b = b;
        this.operation = operation;
    }

    public double calculate () {
        if (operation == Operation.ADD) {
            return a + b;
        }
        else if (operation == Operation.MULTIPLY) {
            return a * b;
        }
        else {
            return a - b;
        }
    }
}
