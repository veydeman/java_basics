public class Main {
    public static void main(String[] args) {
        String path = "C:/Users/jenny/java_basics/FilesAndNetwork/homework_3/data/movementList.csv";
        Movements movements = new Movements(path);
        System.out.println(movements.getExpenseSum());
        System.out.println(movements.getIncomeSum());
    }
}
