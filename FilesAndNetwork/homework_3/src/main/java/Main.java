public class Main {
    public static void main(String[] args) {
        String path = "C:/Users/jenny/java_basics/FilesAndNetwork/homework_3/data/movementList.csv";
        Movements movements = new Movements(path);
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");
        movements.listOperations();
    }
}
