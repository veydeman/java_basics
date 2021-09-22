public class Main {
    private static int c;

    public static void main(String[] args) {
        Arithmetic calculator = new Arithmetic(2, 3);
        c = calculator.prod();
        System.out.println(c);
    }
}
