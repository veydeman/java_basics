public class Main {
    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(3, 6);
        System.out.println(arithmeticCalculator.calculate(Operation.ADD));
        System.out.println(arithmeticCalculator.calculate(Operation.MULTIPLY));
        ArithmeticCalculator arithmeticCalculator1 = new ArithmeticCalculator(19, 5);
        System.out.println(arithmeticCalculator.calculate(Operation.SUBTRACT));

    }
}
