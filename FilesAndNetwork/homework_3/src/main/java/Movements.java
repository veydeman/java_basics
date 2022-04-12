import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    List<Operation> movements = new ArrayList<>();

    public Movements(String pathMovementsCsv) {

        String comma = ",";
        String backSlash = "\"";
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            for (String line : lines) {
                if (line.equals(lines.get(0))) {
                    continue;
                }
                String[] fragments = line
                        .split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (fragments.length != 8) {
                    for (String fragment : fragments) {
                        System.out.println(fragment);
                    }
                    System.out.println("WRONG LINE: " + line);
                    continue;
                }
                movements.add(new Operation(
                        fragments[0],
                        fragments[1],
                        fragments[2],
                        fragments[3],
                        fragments[4],
                        fragments[5],
                        Double.parseDouble(fragments[6].replaceAll(comma, ".")
                                .replaceAll(backSlash, "")),
                        Double.parseDouble(fragments[7].replaceAll(comma, ".")
                                .replaceAll(backSlash, "")
                        )));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (Operation movement : movements) {
            expenseSum = expenseSum + movement.getRashod();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (Operation movement : movements) {
            incomeSum = incomeSum + movement.getPrihod();
        }
        return incomeSum;
    }
}
