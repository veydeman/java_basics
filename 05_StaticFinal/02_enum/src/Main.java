public class Main {
    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(3, 6, Operation.MULTIPLY);
        System.out.println(arithmeticCalculator.calculate());

    }
}
